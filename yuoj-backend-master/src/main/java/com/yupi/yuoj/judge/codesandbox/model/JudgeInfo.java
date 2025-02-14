package com.yupi.yuoj.judge.codesandbox.model;

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudgeInfo {

    /**
     * Programme execution information
     */
    private String message;

    /**
     * Memory consumption
     */
    private Long memory;

    /**
     * Time consumption
     */
    private Long time;
}
