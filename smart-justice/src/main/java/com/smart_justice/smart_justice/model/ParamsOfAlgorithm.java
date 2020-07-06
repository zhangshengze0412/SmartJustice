package com.smart_justice.smart_justice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ParamsOfAlgorithm
 * @description: python算法参数bean
 * @author: ZSZ
 * @date: 2020/7/2 14:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamsOfAlgorithm {

    private String cmd;
    private String program;
    private String file_name;
    private String file_type;
    private String id;
    private String original_claim;
    private String defendant_argued;
    private String threadhold;
    private String case_type;

}
