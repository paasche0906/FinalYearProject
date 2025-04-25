package com.yupi.yuoj.model.dto.file;

import java.io.Serializable;
import lombok.Data;

/**
 * File Upload Request
 */
@Data
public class UploadFileRequest implements Serializable {

    /**
     * professional work
     */
    private String biz;

    private static final long serialVersionUID = 1L;
}