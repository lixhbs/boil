package com.boil.web;

import com.boil.common.DebuggerOrder;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.common.WechatMessageUtils;
import com.boil.entity.WechatMessageParameter;
import com.boil.entity.message.LovelyCatBean;
import com.boil.service.BaseMessageService;
import com.boil.service.DebuggerService;
import com.boil.service.LovelyCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-09 17:58
 */
@RestController
public class WechatController
{
    private static final String ECHOSTR = "echostr";

    @Autowired
    private BaseMessageService baseMessageService;

    @Autowired
    private LovelyCatService lovelyCatService;

    @Autowired
    private DebuggerService debuggerService;


    @RequestMapping("/")
    public Object notify(HttpServletRequest request)
    {
        // TODO 这里要判断下是否是微信调用的接口
        // 。。。

        boolean verify = baseMessageService.checkWechatMessage();
        if (!verify)
        {
            return "非微信客户端请求！";
        }
        String echostr = request.getParameter(ECHOSTR);
        // 微信配置验证
        if (echostr != null)
        {
            return echostr;
        }

        Map<String, String> map = WechatMessageUtils.xmlToMap(request);
        if (map.isEmpty())
        {
            return null;
        }
        return baseMessageService.processRequest(map);
    }

    @RequestMapping("/lovelyCat")
    public Object notifyLovelyCat(@RequestParam Map<String, String> map)
    {
        WechatMessageParameter wechatMessageParameter = WechatMessageUtils.analysisLovelyCat(map);
        String type = wechatMessageParameter.getType();
        String order = wechatMessageParameter.getOrder();

        // 根据内容做转发
        LovelyCatBean lovelyCatBean = new LovelyCatBean();
        lovelyCatBean.setKey("55F8761131A34e5bAEEBD29BB35836E9");
        lovelyCatBean.setRobot_wxid(map.get("robot_wxid"));
        lovelyCatBean.setTo_wxid(wechatMessageParameter.getSource());
        lovelyCatBean.setType("100");

        String content = "";
        if (order.contains(DebuggerOrder.TASK))
        {
            content = debuggerService.pushTask(wechatMessageParameter);
        } else if (order.contains(DebuggerOrder.TODO))
        {
            // 待办
            content = debuggerService.listTodo(wechatMessageParameter);
            if (StringUtils.isNoneEmpty(content) && LovelyCatMessageUtils.TYPE_GROUP.equals(type))
            {
                // 待办 并艾特发命令的人
                content = "\n" + content;
                lovelyCatBean.setType(LovelyCatMessageUtils.TYPE_GROUP_AT);
                lovelyCatBean.setAt_name(wechatMessageParameter.getSender());
                lovelyCatBean.setAt_wxid(wechatMessageParameter.getSenderId());
            }
        } else
        {
            if (LovelyCatMessageUtils.TYPE_PRIVATE.equals(type))
            {
                // 私聊
                // 判断属于私聊的指令
                if (order.contains(DebuggerOrder.HELP))
                {
                    content = debuggerService.debuggerHelp();
                }

                // 待办 完成
                if (order.contains(DebuggerOrder.FINISH))
                {
                    content = debuggerService.todoFinish(wechatMessageParameter);
                }
            }

            if (LovelyCatMessageUtils.TYPE_GROUP.equals(type))
            {
                // 群聊
                // 判断属于群聊的指令
                if (order.contains(DebuggerOrder.TASK))
                {
                    content = debuggerService.pushTask(wechatMessageParameter);
                }
            }
        }

        try
        {
            lovelyCatBean.setMsg(URLEncoder.encode(content, "UTF-8"));
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return lovelyCatService.sendMsg(lovelyCatBean);

    }

    @RequestMapping("/todoReport")
    public void todoReport()
    {
        debuggerService.todoReport("");
    }
}
