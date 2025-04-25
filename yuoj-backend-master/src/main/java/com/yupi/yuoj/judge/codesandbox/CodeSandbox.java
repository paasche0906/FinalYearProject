package com.yupi.yuoj.judge.codesandbox;

import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * Code Sandbox Interface Definition
 */
public interface CodeSandbox {

    /**
     * executable code
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
