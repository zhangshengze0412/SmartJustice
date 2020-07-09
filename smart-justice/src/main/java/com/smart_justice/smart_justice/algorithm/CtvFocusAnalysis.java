package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.model.CtvFocusParams;
import com.smart_justice.smart_justice.util.ParsingResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
        return sub_result;
    }

}
