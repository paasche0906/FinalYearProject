package com.yupi.yuojcodesandbox.security;

import java.security.Permission;

/**
 * Default Security Manager
 */
public class DefaultSecurityManager extends SecurityManager {

    // Check all permissions
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("No restrictions by default");
        System.out.println(perm);
//        super.checkPermission(perm);
    }
}
