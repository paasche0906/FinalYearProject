package com.yupi.yuoj.judge.strategy;

import com.yupi.yuoj.judge.codesandbox.model.JudgeInfo;

/**
 * strategy for deciding questions
 */
public interface JudgeStrategy {

    /**
     * Enforcement of judgements
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
