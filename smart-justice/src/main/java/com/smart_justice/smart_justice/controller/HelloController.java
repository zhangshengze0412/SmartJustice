package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.algorithm.CtvFocusAnalysis;
import com.smart_justice.smart_justice.algorithm.IntelligentQuesAns;
import com.smart_justice.smart_justice.algorithm.RelatedCaseRec;
import com.smart_justice.smart_justice.model.CtvFocusParams;
import com.smart_justice.smart_justice.model.WriteCaseParams;
import com.smart_justice.smart_justice.model.RelatedCaseRecParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:
 * @description:
 * @author: ZSZ
 * @date: 2020/7/3 10:23
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    CtvFocusAnalysis ctvFocusAnalysis;

    @Autowired
    RelatedCaseRec relatedCaseRec;

    @Autowired
    IntelligentQuesAns intelligentQuesAns;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/testCtvFocus")
    public String getResult(){

        CtvFocusParams params = new CtvFocusParams();
        params.setFile_name("Z:\\SmartJustice\\intelligent_justice_flask\\algorithm\\data\\gysh_10_test.csv");
//        params.setFile_name("Z:\\SmartJustice\\intelligent_justice_flask\\algorithm\\data\\testdata_gysh_2.txt");
        //设置参数 file_type 文件类型
        params.setFile_type("csv");
//        params.setFile_type("txt");
        //设置参数 Id 案件Id
        params.setId("None");
        //设置参数 Original_claim 原告诉称
        params.setOriginal_claim("None");
        //设置参数 Defendant_argued 被告辩称
        params.setDefendant_argued("None");
        //设置参数 Threadhold [marry0.2, traffic0.55, zpz0.55, injury0.6...]
        params.setThreadhold("0.6");
        //设置参数 case_type {"marry","traffic","zpz","gysh"}
        params.setCase_type("gysh");
        return ctvFocusAnalysis.predict(params);
    }

    @GetMapping("/testRelCaseRec")
    public String getRelCase(){
        RelatedCaseRecParams params = new RelatedCaseRecParams();
//        params.setCase_description("黑龙江省哈尔滨市平房区人民检察院指控,2015年12月1日10时许,在位于哈尔滨市平房区平房镇的哈尔滨市和鑫集团彩色印刷有限公司正门,该公司保安员被告人闫某甲与来此地办事的被害人梁某甲(男,43岁)因停车一事发生争吵并厮打,梁某甲打了闫某甲一拳,闫某甲打了梁某甲眼部和头部数拳。经法医鉴定,被害人梁某甲左眼眶内壁、眶下壁骨折,损伤程度评定为轻伤一级。被告人闫某甲于2015年12月4日被传唤至公安机关。");
        params.setCase_description("");
        params.setOriginal_claim("");
        params.setDefendant_argued("被告人闫某甲辩称,对公诉机关指控犯有故意伤害罪的事实无异议,请求从轻处罚。");
        return relatedCaseRec.predict(params);
    }

    @GetMapping("/testIntQuesAns")
    public String getAnswer(){
        WriteCaseParams params = new WriteCaseParams();
        params.setCase_description("本院根据原、被告的陈述、举证、质证、本院认证和庭审调查，查明以下事实：原、被告原6夫妻关系。两人于年月日婚生一女许7。2017年6月15日，原、被告通过淮南市八公山区民政局协议离婚。双方在离婚协议中约定：关于子女抚养问题：有一女，名许7,3周岁，归男方抚养，女方无抚养费，女方有探视权。但双方对于探视时间、方式等未进行明确规定。在原告实际行使探视权时，双方亦未能对探视时间和方式等达成一致意见，并产生矛盾分歧，故原告起诉至法院，原告主张探视其女许7的具体时间为每个月第一个星期六上午八点在淮南市八公山区XX小区门口接，第一个星期天下午七点在淮南市八公山区XX小区门口送，第三个星期六星期天的接送时间与第一个星期六星期天一致；暑、寒假放假期间双方各带一半时间，前半段在原告家居住。经本院开庭庭审、庭后调解，原、被告就探望时间及探望次数未能协商达成一致意见。本案争议焦点：原告要求探视其女的诉请是否符合法律规定，能否得到支持。");
        params.setQuestion("女方是否有探视权？");
        return intelligentQuesAns.predict(params);
    }



}
