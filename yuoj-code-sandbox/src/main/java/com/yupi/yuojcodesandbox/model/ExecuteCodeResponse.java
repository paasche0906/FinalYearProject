package com.yupi.yuojcodesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    private List<String> outputList;

    /**
     * interface information
     */
    private String message;

    /**
     * execution status (computing)
     */
    private Integer status;

    /**
     * Judging Information
     */
    private JudgeInfo judgeInfo;
}
