package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RelatedCaseRecParams
 * @description: 相似案例推荐 参数
 * @author: ZSZ
 * @date: 2020/7/8 9:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatedCaseRecParams {

    //案情描述
    private String case_description;
    //原告诉称
    private String original_claim;
    //被告辩称
    private String defendant_argued;

}
