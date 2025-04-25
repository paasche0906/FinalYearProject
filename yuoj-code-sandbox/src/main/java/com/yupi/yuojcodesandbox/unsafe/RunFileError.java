package com.yupi.yuojcodesandbox.unsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Running other programmes (e.g. dangerous Trojans)
 */
public class RunFileError {

    public static void main(String[] args) throws InterruptedException, IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/木马程序.bat";
        Process process = Runtime.getRuntime().exec(filePath);
        process.waitFor();
        // Get the normal output of the process in batches
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        // Read line by line
        String compileOutputLine;
        while ((compileOutputLine = bufferedReader.readLine()) != null) {
            System.out.println(compileOutputLine);
        }
        System.out.println("Successful execution of the exception procedure");
    }
}
