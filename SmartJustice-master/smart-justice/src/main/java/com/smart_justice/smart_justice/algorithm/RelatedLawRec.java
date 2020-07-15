package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: RelatedLawRec
 * @description: 法条推荐
 * @author: ZSZ
 * @date: 2020/7/8 9:55
 */
public class RelatedLawRec {

    @Autowired
    private Execute execute;

    private final String PYTHON_ENV;

    private final String RELATED_LOW_REC_PATH;

    @Autowired
    public RelatedLawRec(PythonEnvProperties envProperties){
        this.PYTHON_ENV = envProperties.getPython_env();
        this.RELATED_LOW_REC_PATH = envProperties.getRelated_law_rec_path();
    }

    public String predict(String params){
        return null;
    }

}
