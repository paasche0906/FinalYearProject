package com.yupi.yuojcodesandbox;


import com.yupi.yuojcodesandbox.model.ExecuteCodeRequest;
import com.yupi.yuojcodesandbox.model.ExecuteCodeResponse;

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
