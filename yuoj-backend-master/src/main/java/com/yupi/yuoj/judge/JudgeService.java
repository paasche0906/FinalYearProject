package com.yupi.yuoj.judge;

import com.yupi.yuoj.model.entity.QuestionSubmit;

/**
 * Problem-solving services
 */
public interface JudgeService {

    /**
     * judgment
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
