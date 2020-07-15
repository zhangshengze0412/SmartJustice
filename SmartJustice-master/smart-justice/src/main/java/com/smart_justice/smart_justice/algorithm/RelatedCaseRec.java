package com.smart_justice.smart_justice.algorithm;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import com.smart_justice.smart_justice.model.RelatedCaseRecParams;
import com.smart_justice.smart_justice.util.ParsingResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: RelatedCaseRec
 * @description: 相关案例推荐
 * @author: ZSZ
 * @date: 2020/7/8 9:00
 */
@Data
@Service
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

        String[] args = {PYTHON_ENV, RELATED_CASE_REC_PATH, params.getCase_description(),
                params.getOriginal_claim(),params.getDefendant_argued()};

        String result = execute.execute(args);
        String sub_result = ParsingResult.parsingResult(result);
        System.out.println(sub_result);
        return sub_result;
    }
}
