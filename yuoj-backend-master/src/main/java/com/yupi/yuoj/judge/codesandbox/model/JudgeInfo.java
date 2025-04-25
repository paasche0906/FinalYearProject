package com.yupi.yuoj.judge.codesandbox.model;

import lombok.Data;

/**
 * Judging Information
 */
@Data
public class JudgeInfo {

    /**
     * programme execution information
     */
    private String message;

    /**
     * memory consumption
     */
    private Long memory;

    /**
     * Consumption time (KB)
     */
    private Long time;
}
