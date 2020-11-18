package com.boil.common;

import com.boil.entity.message.BaseWeChatMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lix.
 * @title 微信消息工具类
 * @Createtime 2020-11-09 19:18
 */
public class LovelyCatMessageUtils
{

    /**
     * 私聊
     */
    public static final String TYPE_PRIVATE = "100";

    /**
     * 群聊
     */
    public static final String TYPE_GROUP = "200";

    /**
     * 群聊aite
     */
    public static final String TYPE_GROUP_AT = "102";



}
