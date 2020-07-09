package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.model.WriteCaseParams;
import com.smart_justice.smart_justice.util.ParsingResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: IntelligentQuesAns
 * @description: 智能问答
 * @author: ZSZ
 * @date: 2020/7/8 9:53
 */
@Data
@Service
public class IntelligentQuesAns {

    @Autowired
    private Execute execute;

    private final String PYTHON_ENV;

    private final String INTELLIGENT_QUES_ANS_PATH;

    private final String INT_QUES_ANS_WRITECASE_PATH;

    @Autowired
    public IntelligentQuesAns(PythonEnvProperties envProperties){
        this.PYTHON_ENV = envProperties.getPython_env();
        this.INTELLIGENT_QUES_ANS_PATH = envProperties.getIntelligent_ques_ans_path();
        this.INT_QUES_ANS_WRITECASE_PATH = envProperties.getInt_ques_ans_writeCase_path();
    }

    public String predict(WriteCaseParams params){
        String[] args = {PYTHON_ENV, INT_QUES_ANS_WRITECASE_PATH,
                params.getCase_description(), params.getQuestion()};
        String result = execute.execute(args);
        if(!result.equals("success\n"))
            return "写入案情参数失败！";
        args = new String[]{PYTHON_ENV, INTELLIGENT_QUES_ANS_PATH};
        result = execute.execute(args);
        String sub_result = ParsingResult.parsingResult(result);
        System.out.println(sub_result);
        return sub_result;
    }


}
