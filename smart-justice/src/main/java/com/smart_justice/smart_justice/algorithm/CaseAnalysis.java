package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.model.ParamsOfAlgorithm;
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
public class CaseAnalysis {

    @Autowired
    private Execute execute;

    private final String python_env;

    private final String case_analysis_path;

    @Autowired
    public CaseAnalysis(PythonEnvProperties envProperties){
        this.python_env = envProperties.getPython_env();
        this.case_analysis_path = envProperties.getCase_analysis_path();
    }

    public String predict(ParamsOfAlgorithm params){

        params.setCmd(this.python_env);
        params.setProgram(this.case_analysis_path);

        String[] args = {params.getCmd(), params.getProgram(), params.getFile_name(),
                params.getFile_type(), params.getId(), params.getOriginal_claim(), params.getDefendant_argued(),
                params.getThreadhold(), params.getCase_type()};

        return execute.execute(args);
    }

}
