package com.yzy.mythread;

public class ThreadTest {
    /**
     * ULT 和 KLT 线程模式
     * JVM 是 C/C++ 写的
     * Java 线程创建是依赖于系统内核，通过 JVM 调用系统库创建内核线程，内核线程与 Java-Thread 是 1:1 的映射关系。
     *
     */
    public static void main(String[] args) {
        for (int i=0;i<200;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t.start();
        }
    }
}
