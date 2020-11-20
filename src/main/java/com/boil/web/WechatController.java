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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author lix.
 */
@RestController
@RequestMapping("/Api")
public class WechatController
{
    private static final String ECHOSTR = "echostr";

    @Autowired
    private BaseMessageService baseMessageService;

    @Autowired
    private LovelyCatService lovelyCatService;

    @Autowired
    private DebuggerService debuggerService;


    @PostMapping("/notify")
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

    @PostMapping("/lovelyCat")
    public Object notifyLovelyCat(@RequestParam Map<String, String> map)
    {
        String type = map.get("type");
        if (LovelyCatMessageUtils.TYPE_PRIVATE.equals(type) || LovelyCatMessageUtils.TYPE_GROUP.equals(type)){
            WechatMessageParameter wechatMessageParameter = WechatMessageUtils.analysisLovelyCat(map);
            String order = wechatMessageParameter.getOrder();

            // 根据内容做转发
            LovelyCatBean lovelyCatBean = new LovelyCatBean();
            lovelyCatBean.setKey("55F8761131A34e5bAEEBD29BB35836E9");
            lovelyCatBean.setRobot_wxid(map.get("robot_wxid"));
            lovelyCatBean.setTo_wxid(wechatMessageParameter.getSource());
            lovelyCatBean.setType("100");

            String content = "";
            if (DebuggerOrder.TASK.equals(order))
            {
                content = debuggerService.pushTask(wechatMessageParameter);
            } else if (DebuggerOrder.TODO.equals(order))
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
            }else if (DebuggerOrder.PROJECT_CODE.equals(order))
            {
                // 项目代码
                content = debuggerService.listProjectCode(wechatMessageParameter);
            } else
            {
                if (LovelyCatMessageUtils.TYPE_PRIVATE.equals(type))
                {
                    // 私聊
                    // 判断属于私聊的指令
                    if (DebuggerOrder.HELP.equals(order))
                    {
                        content = debuggerService.debuggerHelp();
                    }

                    // 待办 完成
                    if (DebuggerOrder.FINISH.equals(order))
                    {
                        content = debuggerService.todoFinish(wechatMessageParameter);
                    }

                    // #实名
                    if (DebuggerOrder.VERIFIED.equals(order))
                    {
                        content = debuggerService.verified(wechatMessageParameter);
                    }
                }

                if (LovelyCatMessageUtils.TYPE_GROUP.equals(type))
                {
                    // 群聊
                    // 判断属于群聊的指令

                    // 注册日报
                    if (DebuggerOrder.DAILY.equals(order))
                    {
                        content = debuggerService.registerDaily(wechatMessageParameter);
                    }

                    // 注册日报
                    if (DebuggerOrder.WEEKLY.equals(order))
                    {
                        content = debuggerService.registerWeekly(wechatMessageParameter);
                    }
                }
            }

            try
            {
                if (StringUtils.isEmpty(content)){
                    return null;
                }
                lovelyCatBean.setMsg(URLEncoder.encode(content, "UTF-8"));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }

            return lovelyCatService.sendMsg(lovelyCatBean);
        }

        return null;
    }

    @PostMapping("/todoReport")
    public void todoReport()
    {
        debuggerService.todoReport("");
    }
}
