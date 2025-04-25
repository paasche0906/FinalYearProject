package com.yupi.yuoj.model.dto.question;

import lombok.Data;

/**
 * Title Configuration
 */
@Data
public class JudgeConfig {

    /**
     * time limit（ms）
     */
    private Long timeLimit;

    /**
     * memory limit（KB）
     */
    private Long memoryLimit;

    /**
     * stack limit（KB）
     */
    private Long stackLimit;
}
