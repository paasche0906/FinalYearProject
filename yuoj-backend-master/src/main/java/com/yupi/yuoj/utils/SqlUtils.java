package com.yupi.yuoj.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * SQL Tools
 */
public class SqlUtils {

    /**
     * Verify that sorted fields are legal (to prevent SQL injection)
     *
     * @param sortField
     * @return
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}
