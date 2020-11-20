package com.boil.common;

import com.boil.entity.WechatMessageParameter;
import com.boil.entity.message.BaseWeChatMessage;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lix.
 * @title 微信消息工具类
 * @Createtime 2020-11-09 19:18
 */
public class WechatMessageUtils
{
    private static final Pattern PATTERN_NICKNAME = Pattern.compile("nickname=(.+?),");

    private static final Pattern PATTERN_WX_ID = Pattern.compile("wxid=(.+?)]");

    private static final Pattern PATTERN_DATE = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");

    private static final Pattern PATTERN_ORDER = Pattern.compile("[#](.+?) ");

    private static final Pattern PATTERN_PROJECT_CODE = Pattern.compile("【(.+[A-Z])】");

    // 各种消息类型,除了扫带二维码事件
    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图片消息
     */
    public static final String MESS_ATGE_IMAGE = "image";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * 小视频消息
     */
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    /**
     * 地理位置消息
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * 事件推送消息
     */
    public static final String MESSAGE_EVENT = "event";
    /**
     * 事件推送消息中,事件类型，subscribe(订阅)
     */
    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
    /**
     * 事件推送消息中,事件类型，unsubscribe(取消订阅)
     */
    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件推送消息中,上报地理位置事件
     */
    public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
     */
    public static final String MESSAGE_EVENT_CLICK = "CLICK";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
     */
    public static final String MESSAGE_EVENT_VIEW = "VIEW";


    /**
     * 将xml转化为Map集合
     *
     * @param request
     * @return
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(6);
        SAXReader reader = new SAXReader();
        InputStream ins = null;
        try
        {
            ins = request.getInputStream();
            Document read = reader.read(ins);
            Element root = read.getRootElement();
            List<Element> list = root.elements();
            for (Element e : list) {
                map.put(e.getName(), e.getText());
            }
        } catch (IOException | DocumentException e)
        {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 文本消息转化为xml
     *
     * @param wechatMessageBase wechatMessageBase
     * @return String
     */
    public static String textMessageToXml(BaseWeChatMessage wechatMessageBase) {
        XStream xstream = new XStream();
        xstream.alias("xml", wechatMessageBase.getClass());
        return xstream.toXML(wechatMessageBase);
    }

    public static String getMsgNickname(String msg){
        Matcher matcherNickname = PATTERN_NICKNAME.matcher(msg);
        String nickname = "";
        if(matcherNickname.find()){
            nickname = matcherNickname.group(1);
        }
        if (StringUtils.isNoneEmpty(nickname)){
            nickname = nickname.trim();
        }
        return nickname;
    }

    public static String getMsgWxId(String msg){
        Matcher matcherWxId = PATTERN_WX_ID.matcher(msg);
        String wxId = "";
        if(matcherWxId.find()){
            wxId = matcherWxId.group(1);
        }
        if (StringUtils.isNoneEmpty(wxId)){
            wxId = wxId.trim();
        }
        return wxId;
    }
    public static String getMsgDate(String msg){
        Matcher m = PATTERN_DATE.matcher(msg);
        String date = "";
        if(m.find()){
            date = m.group(0);
        }
        if (StringUtils.isNoneEmpty(date)){
            date = date.trim();
        }
        return date;
    }

    public static String getProjectCode(String msg){
        Matcher m = PATTERN_PROJECT_CODE.matcher(msg);
        String date = "";
        if(m.find()){
            date = m.group(1);
        }
        if (StringUtils.isNoneEmpty(date)){
            date = date.trim();
        }
        return date;
    }

    public static String getMsgOrder(String msg){
        Matcher m = PATTERN_ORDER.matcher(msg);
        String order = "";
        if(m.find()){
            order = m.group(0);
        }
        if (StringUtils.isNoneEmpty(order)){
            order = order.trim();
        } else {
            order = msg;
        }
        return order;
    }

    public static WechatMessageParameter analysisMsg(String msg)
    {
        if (StringUtils.isEmpty(msg))
        {
            throw new NullPointerException("msg不能为空字符串");
        }
        // 解析指令
        WechatMessageParameter wechatMessageParameter = new WechatMessageParameter();
        wechatMessageParameter.setAssigner(getMsgNickname(msg));
        wechatMessageParameter.setAssignerId(getMsgWxId(msg));
        String msgOrder = getMsgOrder(msg);
        wechatMessageParameter.setOrder(msgOrder);
        String projectCode = getProjectCode(msg);
        wechatMessageParameter.setProjectCode(projectCode);

        // 时间处理
        String strDate = getMsgDate(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        wechatMessageParameter.setDate(LocalDate.now());
        if ( StringUtils.isNotEmpty(strDate))
        {
            wechatMessageParameter.setDate(LocalDate.parse(strDate, formatter));
        }

        String content = "";
        if(!msg.equals(msgOrder)) {
            content = msg.replaceAll(msgOrder, "")
                    .replaceAll("\\[@at(.+?)[]]", "")
                    .replaceAll("[0-9]{4}-[0-9]{2}-[0-9]{2}", "")
                    .replaceAll(WechatMessageUtils.PATTERN_PROJECT_CODE.toString(), "")
                    .trim();
        }
        wechatMessageParameter.setContent(content);
        return wechatMessageParameter;
    }

    /**
     * 可爱猫的请求参数解析
     * @author Lix.
     * @param map 可爱猫请求参数
     * @return WechatMessageParameter
     * @date 2020/11/17 10:45
     */
    public static WechatMessageParameter analysisLovelyCat(Map<String, String> map)
    {
        if (null == map || map.isEmpty())
        {
            throw new NullPointerException("参数不能为空字符串");
        }
        WechatMessageParameter wechatMessageParameter = null;
        String msg = map.get("msg");
        wechatMessageParameter = analysisMsg(msg);
        String type = map.get("type");

        wechatMessageParameter.setType(type);
        wechatMessageParameter.setMsg(msg);
        String fromWxId = map.get("from_wxid");
        String fromName = map.get("from_name");
        // 创建id要判断下， 如果再群里面 应该是final_from_wxid
        wechatMessageParameter.setSource(fromWxId);
        wechatMessageParameter.setSenderId(fromWxId);
        wechatMessageParameter.setSender(fromName);
        if(LovelyCatMessageUtils.TYPE_GROUP.equals(wechatMessageParameter.getType()))
        {
            wechatMessageParameter.setSenderId(map.get("final_from_wxid"));
            wechatMessageParameter.setSender(map.get("final_from_name"));
            wechatMessageParameter.setGroupId(fromWxId);
        }

        if(LovelyCatMessageUtils.TYPE_PRIVATE.equals(wechatMessageParameter.getType()))
        {
            wechatMessageParameter.setAssignerId(fromWxId);
            wechatMessageParameter.setAssigner(fromName);
        }

        return wechatMessageParameter;
    }
}
