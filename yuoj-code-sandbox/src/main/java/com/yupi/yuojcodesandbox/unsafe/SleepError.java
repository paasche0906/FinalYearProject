package com.yupi.yuojcodesandbox.unsafe;

/**
 * Infinite sleep (blocking programme execution)
 */
public class SleepError {

    public static void main(String[] args) throws InterruptedException {
        long ONE_HOUR = 60 * 60 * 1000L;
        Thread.sleep(ONE_HOUR);
        System.out.println("I'm done sleeping.");
    }
}
