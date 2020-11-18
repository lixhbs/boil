package com.boil.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    private static final String CODE = "0";
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

    /**
     * 字符串转json数组
     * @author Lix.
     * @param str json数组字符串
     * @return JSONArray
     * @date 2020/11/18 11:38s
     */
    public static JSONArray stringToJsonArray(String str) throws UnsupportedEncodingException
    {
        if (str == null)
        {
            throw new NullPointerException("参数为空！");
        }
        JSONArray jsonArray = null;
        JSONObject parse = (JSONObject) JSONObject.parse(str);
        String code = parse.getString("code");
        if (CODE.equals(code)){
            String data = parse.getString("data");
            data = URLDecoder.decode(data, "UTF-8");
            if (StringUtils.isNoneEmpty())
            {
                jsonArray = (JSONArray) JSONArray.parse(data);
            }
        }
        return jsonArray;
    }

}
