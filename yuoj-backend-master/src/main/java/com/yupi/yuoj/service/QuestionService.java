package com.yupi.yuoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yuoj.model.dto.question.QuestionQueryRequest;
import com.yupi.yuoj.model.entity.Question;
import com.yupi.yuoj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;


public interface QuestionService extends IService<Question> {


    /**
     * calibration
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * Get query conditions
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);
    
    /**
     * Get the title package
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * Paging for topic encapsulation
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
    
}
