package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.mapper.CourtMapper;
import com.smart_justice.smart_justice.model.*;
import com.smart_justice.smart_justice.util.ParseJsonToObj;
import com.smart_justice.smart_justice.util.ParsingResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @className: CaseAnalysis
 * @description: 案件分析
 *                  1. 分析单个案件（txt、docx），返回结果
 *                  2. 分析多个案件(csv)，测算准确率（F值）
 * @author: ZSZ
 * @date: 2020/7/3 0:57
 */
@Data
@Service
public class CtvFocusAnalysis {

    @Autowired
    private Execute execute;

    @Autowired
    CourtMapper courtMapper;

    private final String PYTHON_ENV;

    private final String CTV_FOCUS_ANALYSIS_PATH;

    @Autowired
    public CtvFocusAnalysis(PythonEnvProperties envProperties){
        this.PYTHON_ENV = envProperties.getPython_env();
        this.CTV_FOCUS_ANALYSIS_PATH = envProperties.getCtv_focus_analysis_path();
    }

    public String predict(CtvFocusParams params){

        params.setCmd(this.PYTHON_ENV);
        params.setProgram(this.CTV_FOCUS_ANALYSIS_PATH);

        String[] args = {params.getCmd(), params.getProgram(), params.getFile_name(),
                params.getFile_type(), params.getId(), params.getOriginal_claim(), params.getDefendant_argued(),
                params.getThreadhold(), params.getCase_type()};

        String result = execute.execute(args);
        String sub_result = ParsingResult.parsingResult(result);
        sub_result = sub_result.replace('\'','\"');
//        System.out.println(sub_result);

        if(!params.getFile_type().equals("csv")){
            switch (params.getCase_type()){
                case "marry":
                    MarryCase marryCase = ParseJsonToObj.toMarry(sub_result);
                    if(marryCase != null){
                        courtMapper.insertMarry(marryCase);
                        courtMapper.withTabIndex(marryCase.getId(),1);
                    }
                    break;
                case "traffic":
                    TrafficCase trafficCase = ParseJsonToObj.toTraffic(sub_result);
                    if(trafficCase != null){
                        courtMapper.insertTraffic(trafficCase);
                        courtMapper.withTabIndex(trafficCase.getId(),3);
                    }
                    break;
                case "zpz":
                    ScamCase scamCase = ParseJsonToObj.toScam(sub_result);
                    if(scamCase != null){
                        courtMapper.insertScam(scamCase);
                        courtMapper.withTabIndex(scamCase.getId(),2);
                    }
                    break;
                case "gysh":
                    IntentionalInjuryCase intentionalInjuryCase = ParseJsonToObj.toIntent(sub_result);
                    if(intentionalInjuryCase != null){
                        courtMapper.insertIntent(intentionalInjuryCase);
                        courtMapper.withTabIndex(intentionalInjuryCase.getId(),0);
                    }
                    break;
                default:
            }
        }



        return sub_result;
    }

}
