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

    private String python_env;
    private String case_analysis_path;

}

