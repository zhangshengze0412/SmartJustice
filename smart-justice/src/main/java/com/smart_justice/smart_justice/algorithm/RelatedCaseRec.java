package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.model.RelatedCaseRecParams;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: RelatedCaseRec
 * @description: 相关案例推荐
 * @author: ZSZ
 * @date: 2020/7/8 9:00
 */
public class RelatedCaseRec {

    @Autowired
    private Execute execute;

    private final String PYTHON_ENV;

    private final String RELATED_CASE_REC_PATH;

    @Autowired
    public RelatedCaseRec(PythonEnvProperties envProperties){
        this.PYTHON_ENV = envProperties.getPython_env();
        this.RELATED_CASE_REC_PATH = envProperties.getRelated_case_rec_path();
    }

    public String predict(RelatedCaseRecParams params){
        return null;
    }
}
