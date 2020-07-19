package com.smart_justice.smart_justice.algorithm;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @className: Execute
 * @description: 执行脚本
 * @author: ZSZ
 * @date: 2020/7/3 1:05
 */

@Service
public class Execute {

    public String execute(String[] args){
        try {
//            long start  = System.currentTimeMillis();
            //cmd:param1:python.exe路径,param2:要执行的脚本路径,param3:传参,param4.....
            Process proc = Runtime.getRuntime().exec(args);// 执行命令
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gbk"));
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8));
            //接收错误流
            BufferedReader isError = new BufferedReader(new InputStreamReader(proc.getErrorStream(),"gbk"));
//            BufferedReader isError = new BufferedReader(new InputStreamReader(proc.getErrorStream(),StandardCharsets.UTF_8));
            StringBuilder sb= new StringBuilder();
            StringBuilder sbError = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String lineError = null;
            while ((lineError= isError.readLine()) != null) {
                sbError.append(lineError);
                sbError.append("\n");
            }
            System.out.println("sbError: "+sbError);
            in.close();
            isError.close();
            proc.waitFor();
//            System.out.println("time:" + (System.currentTimeMillis()-start));
//            String result = sb.toString().replace('\'','\"');
//            System.out.println(result);
//            System.out.println(sb.toString()+sbError.toString());

            return sb.toString()+sbError.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
