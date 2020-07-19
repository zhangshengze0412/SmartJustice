package com.smart_justice.smart_justice.algorithm;

import com.alibaba.fastjson.JSONObject;
import com.smart_justice.smart_justice.mapper.CourtMapper;
import com.smart_justice.smart_justice.model.*;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackFor = RuntimeException.class)
@Service
public class CourtService {

    @Autowired
    CourtMapper courtMapper;

    public static Content getFileContent(MultipartFile file) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType;
                String finalFileName;
//            String dir_path = CourtService.class.getResource("/").getPath() + "/cases";
                if (fileName != null && !fileName.equals("")) {
                    fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //设置通用唯一识别码，解决重名
                    finalFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                } else {
                    return null;
                }
                if (!fileType.equals("") && (fileType.equals("txt") || fileType.equals("docx"))) {
//            String path = new File(dir_path).getAbsolutePath() + "\\" + finalFileName;
//                    String path = "D:\\IdeaProjects\\smart-justice\\cases"+ "\\" + finalFileName;
                    String path = "/usr/local/SpringbootProjects/smartjustice/cases/" + finalFileName;
//            System.out.println(path);
                    File f = new File(path);
                    file.transferTo(f);
                    boolean flag1 = false;
                    boolean flag2 = false;
                    boolean flag3 = false;
                    if (fileType.equals("txt")) {
                        Content txtContent = new Content();
                        BufferedReader buf = new BufferedReader(new FileReader(f));
                        String line = null;
                        while ((line = buf.readLine()) != null) {
                            if (line.equals("ID：")) {
                                flag1 = true;
                            } else if (line.equals("原告诉称：")) {
                                flag1 = false;
                                flag2 = true;
                            } else if (line.equals("被告辩称：")) {
                                flag2 = false;
                                flag3 = true;
                            } else if (flag1) {   //开始读取ID
                                txtContent.setID(txtContent.getID() + line);
                            } else if (flag2) {  //开始读取原告诉称
                                txtContent.setOriginal_claim(txtContent.getOriginal_claim() + line);
                            } else if (flag3) {  //开始读取被告诉称
                                txtContent.setDefendant_argued(txtContent.getDefendant_argued() + line);
                            }
                        }
                        buf.close();
                        return txtContent;
                    } else {
                        Content docxContent = new Content();
                        FileInputStream fis = new FileInputStream(f);
                        XWPFDocument xdoc = new XWPFDocument(fis);
                        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                        String doc1 = extractor.getText();
                        String[] ss = doc1.split("\n");
                        for (String s : ss) {
                            if (s.equals("ID：")) {
                                flag1 = true;
                            } else if (s.equals("原告诉称：")) {
                                flag1 = false;
                                flag2 = true;
                            } else if (s.equals("被告辩称：")) {
                                flag2 = false;
                                flag3 = true;
                            } else if (flag1) {   //开始读取ID
                                docxContent.setID(docxContent.getID() + s);
                            } else if (flag2) {  //开始读取原告诉称
                                docxContent.setOriginal_claim(docxContent.getOriginal_claim() + s);
                            } else if (flag3) {  //开始读取被告诉称
                                docxContent.setDefendant_argued(docxContent.getDefendant_argued() + s);
                            }
                        }
                        fis.close();
                        return docxContent;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }


    /**
     * 表索引：0-intentinjurycase, 1-marrycase, 2-scamcase, 3-trafficcase
     *
     * @param id
     * @param recommend
     * @return
     */
    public Result expertRec(String id, String recommend) {
        Result result = new Result();
        try {
            List<Integer> tabIds = courtMapper.getTabId(id);
            if (tabIds.isEmpty()) {
                result.setMsg("未找到该案件");
                result.setStatus("500");
                return result;
            }
            for (Integer tabId : tabIds) {
                switch (tabId) {
                    case 0:
                        courtMapper.updateIntent(id, recommend);
                    case 1:
                        courtMapper.updateMarry(id, recommend);
                    case 2:
                        courtMapper.updateScam(id, recommend);
                    case 3:
                        courtMapper.updateTraffic(id, recommend);
                }
            }
            result.setMsg("更新建议成功");
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setStatus("500");
        }
        return result;
    }


    public String useCaseID(String caseID, String caseType) {
        boolean flag = true;
        if(caseType != null && !caseType.equals("")){
            switch (caseType){
                case "marry":
                    MarryCase marryCase = courtMapper.getMarryCaseById(caseID);
                    if(marryCase != null){
                        return JSONObject.toJSONString(marryCase);
                    }else{
                        return "未找到该ID所指的案件！";
                    }
                case "traffic":
                    TrafficCase trafficCase = courtMapper.getTrafficCaseById(caseID);
                    if(trafficCase != null){
                        return JSONObject.toJSONString(trafficCase);
                    }else{
                        return "未找到该ID所指的案件！";
                    }
                case "zpz":
                    ScamCase scamCase = courtMapper.getScamCaseById(caseID);
                    if(scamCase != null){
                        return JSONObject.toJSONString(scamCase);
                    }else{
                        return "未找到该ID所指的案件！";
                    }
                case "gysh":
                    IntentionalInjuryCase intentionalInjuryCase = courtMapper.getIntentionalInjuryCaseById(caseID);
                    if(intentionalInjuryCase != null){
                        return JSONObject.toJSONString(intentionalInjuryCase);
                    }else{
                        return "未找到该ID所指的案件！";
                    }
                default:
                    return "案件类型有误！";
            }
        }else{
            return "未指定案件类型！";
        }
    }
}
