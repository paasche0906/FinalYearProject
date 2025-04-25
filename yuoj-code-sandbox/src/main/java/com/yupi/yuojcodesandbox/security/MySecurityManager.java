package com.yupi.yuojcodesandbox.security;

import java.security.Permission;

public class MySecurityManager extends SecurityManager {


    // Check all permissions
    @Override
    public void checkPermission(Permission perm) {
//        super.checkPermission(perm);
    }

    // Detecting whether a programme is executable
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec Privilege Exception:" + cmd);
    }

    // Detect whether the programme is allowed to read the file

    @Override
    public void checkRead(String file) {
        System.out.println(file);
        if (file.contains("C:\\code\\yuoj-code-sandbox")) {
            return;
        }
    }

    // Detecting whether a program is allowed to write a file
    @Override
    public void checkWrite(String file) {
    }

    // Detect whether the programme is allowed to delete files
    @Override
    public void checkDelete(String file) {
    }

    // Detect whether the programme is allowed to connect to the network
    @Override
    public void checkConnect(String host, int port) {
    }
}
