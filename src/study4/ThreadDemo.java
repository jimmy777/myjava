package study4;

class ThreadTest extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("[Thread-A] " + i);
        }
    }
}


public class ThreadDemo {
    // 主方法线程由 JVM 负责
    public static void main(String[] args) {
        // 启动一个 ThreadTest 线程
//        new ThreadTest().start();

        // 定义匿名内部类，该类实现 Runnable 接口
        Thread t = new Thread(new Runnable() {
            int i = 0;

            // 重写 run() 方法
            @Override
            public void run() {
                while (true) {
                    i++;
                    System.out.println("[Thread-B] " + i);
                    if (i == 50)
                        break;
                }
            }
        });

        System.out.println(t.getPriority());
        System.out.println(t.getName());
        t.start();
    }
}
