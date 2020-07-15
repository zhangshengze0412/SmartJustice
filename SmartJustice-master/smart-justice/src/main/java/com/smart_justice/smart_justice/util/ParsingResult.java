package com.smart_justice.smart_justice.util;

/**
 * @className: ParsingResult
 * @description: 处理 python返回的结果
 * @author: ZSZ
 * @date: 2020/7/9 10:38
 */
public class ParsingResult {

    //提取python处理的结果
    public static String parsingResult(String result){
        int pos_start = result.indexOf("<json>");
        int pos_end = result.indexOf("</json>");
        String sub_result = null;
        if(pos_start == -1 || pos_end == -1)sub_result = result;
        else sub_result = result.substring(pos_start+"<json>".length(),pos_end);

        return sub_result;
    }

}
