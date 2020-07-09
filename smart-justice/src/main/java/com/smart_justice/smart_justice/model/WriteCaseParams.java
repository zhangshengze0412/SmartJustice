package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: WriteCaseParams
 * @description: 写入智能问答案脚本情参数
 * @author: ZSZ
 * @date: 2020/7/9 13:43
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteCaseParams {

    // 案情描述
    private String case_description;
    //问题
    private String question;

}
