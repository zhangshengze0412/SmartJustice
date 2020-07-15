package com.smart_justice.smart_justice;

import com.smart_justice.smart_justice.config.PythonEnvProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.smart_justice.smart_justice.mapper")
@ServletComponentScan("com.smart_justice.smart_justice.filter")
//在@SpringBootApplication注解的类中添加
//@EnableConfigurationProperties注解以开启ConfigurationProperties功能。
@EnableConfigurationProperties({
        PythonEnvProperties.class
})
@EnableTransactionManagement
//打开计时器
//@EnableTransactionManagement
//@EnableScheduling
public class SmartJusticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartJusticeApplication.class, args);
    }

}
