package com.yupi.yuojcodesandbox.security;

import java.security.Permission;

/**
 * Disable All Rights Security Manager
 */
public class DenySecurityManager extends SecurityManager {

    // Check all permissions
    @Override
    public void checkPermission(Permission perm) {
        throw new SecurityException("Permission exception:" + perm.toString());
    }
}
