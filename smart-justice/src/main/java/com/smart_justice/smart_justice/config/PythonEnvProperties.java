package com.smart_justice.smart_justice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className: PythonEnvProperties
 * @description: python 环境
 * @author: ZSZ
 * @date: 2019/10/30 15:33
 */
@ConfigurationProperties(prefix = "python.env")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PythonEnvProperties {

    //python 运行环境
    private String python_env;
    //争议焦点分析脚本
    private String ctv_focus_analysis_path;
    //相似案例推荐脚本
    private String related_case_rec_path;
    //智能问答脚本
    private String intelligent_ques_ans_path;
    //智能问答写入案情脚本
    private String int_ques_ans_writeCase_path;
    //法条推荐脚本
    private String related_law_rec_path;

}

