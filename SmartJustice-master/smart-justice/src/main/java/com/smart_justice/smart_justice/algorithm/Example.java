package com.smart_justice.smart_justice.algorithm;

/**
 * @className: Example
 * @description: 调用python算法的例子
 * @author: ZSZ
 * @date: 2020/7/2 10:23
 */
public class Example {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Process proc;
//        try {
//
//            CtvFocusParams params = new CtvFocusParams();
//            //python运行环境
//            params.setCmd("Z:\\SmartJustice\\intelligent_justice_flask\\venv\\Scripts\\python.exe");
//            //python脚本
//            params.setProgram("Z:\\SmartJustice\\intelligent_justice_flask\\algorithm\\algorithm_example.py");
////            params.setFile_name("Z:\\SmartJustice\\intelligent_justice_flask\\algorithm\\data\\testdata_gysh_2.txt");
////            params.setFile_type("txt");
//            //设置参数 file_name 文件路径
//            params.setFile_name("Z:\\SmartJustice\\intelligent_justice_flask\\algorithm\\data\\gysh_10_test.csv");
//            //设置参数 file_type 文件类型
//            params.setFile_type("csv");
//            //设置参数 Id 案件Id
//            params.setId("None");
//            //设置参数 Original_claim 原告诉称
//            params.setOriginal_claim("None");
//            //设置参数 Defendant_argued 被告辩称
//            params.setDefendant_argued("None");
//            //设置参数 Threadhold [marry0.2, traffic0.55, zpz0.55, injury0.6...]
//            params.setThreadhold("0.6");
//            //设置参数 case_type {"marry","traffic","zpz","gysh"}
//            params.setCase_type("gysh");
//
//            String[] str = {
//                    params.getCmd(),
//                    params.getProgram(),
//                    params.getFile_name(),
//                    params.getFile_type(),
//                    params.getId(),
//                    params.getOriginal_claim(),
//                    params.getDefendant_argued(),
//                    params.getThreadhold(),
//                    params.getCase_type()
//            };
//
//            //cmd:param1:python.exe路径,param2:要执行的脚本路径,param3:传参,param4.....
//            proc = Runtime.getRuntime().exec(str);// 执行命令
//
//            //用输入输出流来截取结果
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gbk"));
//            //接收错误流
//            BufferedReader isError = new BufferedReader(new InputStreamReader(proc.getErrorStream(),"gbk"));
//            StringBuilder sb= new StringBuilder();
//            StringBuilder sbError = new StringBuilder();
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                sb.append(line);
//                sb.append("\n");
//            }
//            String lineError = null;
//            while ((lineError= isError.readLine()) != null) {
//                sbError.append(lineError);
//                sbError.append("\n");
//            }
//            in.close();
//            isError.close();
//            proc.waitFor();
//            String result = sb.toString().replace('\'','\"');
//            System.out.println(result);
////            System.out.println(sb.toString()+sbError.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

}
