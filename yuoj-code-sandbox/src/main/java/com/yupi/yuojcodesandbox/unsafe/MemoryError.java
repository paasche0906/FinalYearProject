package com.yupi.yuojcodesandbox.unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Unlimited space usage (waste of system memory)
 */
public class MemoryError {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            bytes.add(new byte[10000]);
        }
    }
}
