package com.yupi.yuoj.common;

import com.yupi.yuoj.constant.CommonConstant;
import lombok.Data;

/**
 * paging request
 */
@Data
public class PageRequest {

    /**
     * current page number
     */
    private long current = 1;

    /**
     * paper size
     */
    private long pageSize = 10;

    /**
     * Sort Fields
     */
    private String sortField;

    /**
     * Sort order (default ascending)
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
