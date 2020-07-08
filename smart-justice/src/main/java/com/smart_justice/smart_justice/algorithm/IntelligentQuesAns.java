package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: IntelligentQuesAns
 * @description: 智能问答
 * @author: ZSZ
 * @date: 2020/7/8 9:53
 */
public class IntelligentQuesAns {

    @Autowired
    private Execute execute;

    private final String PYTHON_ENV;

    private final String INTELLIGENT_QUES_ANS_PATH;

    @Autowired
    public IntelligentQuesAns(PythonEnvProperties envProperties){
        this.PYTHON_ENV = envProperties.getPython_env();
        this.INTELLIGENT_QUES_ANS_PATH = envProperties.getIntelligent_ques_ans_path();
    }

    public String predict(String params){
        return null;
    }


}
