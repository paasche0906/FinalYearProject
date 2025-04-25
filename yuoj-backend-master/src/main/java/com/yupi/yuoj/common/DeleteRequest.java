package com.yupi.yuoj.common;

import java.io.Serializable;
import lombok.Data;

/**
 * Delet request
 *
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}