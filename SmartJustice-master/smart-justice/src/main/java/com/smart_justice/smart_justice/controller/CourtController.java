package com.smart_justice.smart_justice.controller;

import com.smart_justice.smart_justice.algorithm.CourtService;
import com.smart_justice.smart_justice.algorithm.CtvFocusAnalysis;
import com.smart_justice.smart_justice.algorithm.IntelligentQuesAns;
import com.smart_justice.smart_justice.algorithm.RelatedCaseRec;
import com.smart_justice.smart_justice.model.CtvFocusParams;
import com.smart_justice.smart_justice.model.Result;
import com.smart_justice.smart_justice.model.WriteCaseParams;
import com.smart_justice.smart_justice.model.RelatedCaseRecParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @className:
 * @description:
 * @author: ZSZ
 * @date: 2020/7/3 10:23
 */
@RestController
public class CourtController {

    @Autowired
    CtvFocusAnalysis ctvFocusAnalysis;

    @Autowired
    RelatedCaseRec relatedCaseRec;

    @Autowired
    IntelligentQuesAns intelligentQuesAns;

    @Autowired
    CourtService courtService;

    @PostMapping("/court/ctvFocus")
    public String getResult(MultipartFile file, String fileType, String plaintiff_claim, String defendant_claim, String caseType) {
//    public String getResult(){
//        Result result = new Result();
        CtvFocusParams params = new CtvFocusParams();
        if (fileType != null && !fileType.equals("")) {
//        String fileType = "txt";
            String fileName = file.getOriginalFilename();
//        System.out.println(fileName);
            String dir_path = CourtController.class.getResource("/").getPath() + "/cases";
//        System.out.println(dir_path);
            String finalFileName;
            if (fileName != null && !fileName.equals("")) {
                //设置通用唯一识别码，解决重名
                finalFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
            } else {
                return "";   //standard
            }
            String path = new File(dir_path).getAbsolutePath() + "\\" + finalFileName;
//            System.out.println(path);
            File f = new File(path);
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            }
            params.setFile_name(path);
            if (fileType.equals("docx") || fileType.equals("txt")) {   //争议焦点
                //设置参数 file_type 文件类型
                params.setFile_type(fileType);
            } else if (fileType.equals("csv")) {
                //设置参数 file_type 文件类型
                params.setFile_type("csv");
            } else {
                return "";  //standard
            }
            //设置参数 Id 案件Id
            params.setId("None");
            //设置参数 Original_claim 原告诉称
            params.setOriginal_claim("None");
            //设置参数 Defendant_argued 被告辩称
            params.setDefendant_argued("None");
        } else {
            //设置参数 Id 案件Id
            params.setFile_name("None");
            params.setFile_type("None");
            params.setId("111520");
//            System.out.println(plaintiff_claim);
//            System.out.println(defendant_claim);
            //设置参数 Original_claim 原告诉称
            params.setOriginal_claim(plaintiff_claim);
            //设置参数 Defendant_argued 被告辩称
            params.setDefendant_argued(defendant_claim);
        }

        //------------------------------------------------
//        CtvFocusParams params = new CtvFocusParams();
////        params.setFile_name("C:\\Users\\DELL\\Desktop\\gysh_10_test.csv");
////        params.setFile_type("csv");
//        //设置参数 Id 案件Id
//        params.setFile_name("None");
//        params.setFile_type("None");
//        params.setId("None");
//        String original_claim = null;
//        String defendant_argued = null;
//        try {
//            original_claim = new String("原告赵某1向本院提出诉讼请求：1.判令原、被告离婚；2.婚生女赵某2由原告抚养；3.依法分割夫妻共同财产；4.被告承担本案诉讼费用。事实和理由：原、被告于2004年6月经人介绍相识，××××年××月××日登记结婚，××××年××月××日生一女赵某2。由于婚前缺乏了解，草率结婚，婚后双方在兴趣爱好、人生追求和性格等方面存在较大差异，双方经常为家庭琐事争吵，没有共同语言，无法正常沟通。原告为了孩子，一直隐忍维持这段婚姻，被告性格怪癖，日积月累，双方矛盾不断激化，无和好可能。综上，原、被告双方未建立起真正的夫妻感情，为维护自身合法权益，特诉至法院，恳请法院判如所请。为维护自身合法权益，特诉至法院，恳请法院判如所请.".getBytes(),"GBK");
//            defendant_argued = new String("被告翁某辩称，我和原告之间没有实质性的矛盾，主要是因为原告向着他家里人，如果被告能处理好他家人和我及我家人之间的矛盾，我们之间的感情是没有问题的。离婚对小孩影响很大，不利于小孩身心健康发展，为了给小孩一个完整的家庭，我不同意离婚。".getBytes(),"GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        //设置参数 Original_claim 原告诉称
//        params.setOriginal_claim(original_claim);
//        //设置参数 Defendant_argued 被告辩称
//        params.setDefendant_argued(defendant_argued);
        //-----------------------------------------------

        String[] thresholds = {"0.2","0.55","0.55","0.6"};
        String[] case_types = {"marry","traffic","zpz","gysh"};

        String threshold = thresholds[0];
        String case_type = case_types[0];
        for(int i=0;i<case_types.length;i++){
            if(case_types[i].equals(caseType)){
                case_type = caseType;
                threshold = thresholds[i];
                break;
            }
        }

        //设置参数 Threadhold [marry0.2, traffic0.55, zpz0.55, injury0.6...]
        params.setThreadhold(threshold);
        //设置参数 case_type {"marry","traffic","zpz","gysh"}
        params.setCase_type(case_type);

        return ctvFocusAnalysis.predict(params);
    }

    @PutMapping("/court/ctvFocus/{id}")
    public Result expertRec(@PathVariable("id") String id, @RequestBody Map<String,String> map){
        return courtService.expertRec(id,map.get("recommend"));
    }

    @PostMapping("/relatedCaseRec")
    public String getRelCase(@RequestBody Map<String,String> map) {
        RelatedCaseRecParams params = new RelatedCaseRecParams();
//        params.setCase_description("黑龙江省哈尔滨市平房区人民检察院指控,2015年12月1日10时许,在位于哈尔滨市平房区平房镇的哈尔滨市和鑫集团彩色印刷有限公司正门,该公司保安员被告人闫某甲与来此地办事的被害人梁某甲(男,43岁)因停车一事发生争吵并厮打,梁某甲打了闫某甲一拳,闫某甲打了梁某甲眼部和头部数拳。经法医鉴定,被害人梁某甲左眼眶内壁、眶下壁骨折,损伤程度评定为轻伤一级。被告人闫某甲于2015年12月4日被传唤至公安机关。");
//        params.setCase_description("");
//        params.setOriginal_claim("");
//        params.setDefendant_argued("被告人闫某甲辩称,对公诉机关指控犯有故意伤害罪的事实无异议,请求从轻处罚。");
        params.setCase_description(map.get("case_description"));
        params.setDefendant_argued(map.get("defendant_argued"));
        params.setOriginal_claim(map.get("original_claim"));
        return relatedCaseRec.predict(params);
    }

    @PostMapping("/intQuesAns")
    public String getAnswer(@RequestBody Map<String,String> map) {
        WriteCaseParams params = new WriteCaseParams();
//        params.setCase_description("本院根据原、被告的陈述、举证、质证、本院认证和庭审调查，查明以下事实：原、被告原6夫妻关系。两人于年月日婚生一女许7。2017年6月15日，原、被告通过淮南市八公山区民政局协议离婚。双方在离婚协议中约定：关于子女抚养问题：有一女，名许7,3周岁，归男方抚养，女方无抚养费，女方有探视权。但双方对于探视时间、方式等未进行明确规定。在原告实际行使探视权时，双方亦未能对探视时间和方式等达成一致意见，并产生矛盾分歧，故原告起诉至法院，原告主张探视其女许7的具体时间为每个月第一个星期六上午八点在淮南市八公山区XX小区门口接，第一个星期天下午七点在淮南市八公山区XX小区门口送，第三个星期六星期天的接送时间与第一个星期六星期天一致；暑、寒假放假期间双方各带一半时间，前半段在原告家居住。经本院开庭庭审、庭后调解，原、被告就探望时间及探望次数未能协商达成一致意见。本案争议焦点：原告要求探视其女的诉请是否符合法律规定，能否得到支持。");
//        params.setQuestion("女方是否有探视权？");
        params.setCase_description(map.get("case_description"));
        params.setQuestion(map.get("question"));
        return intelligentQuesAns.predict(params);
    }


}
