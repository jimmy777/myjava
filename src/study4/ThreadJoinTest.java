package study4;

public class ThreadJoinTest implements Runnable {
    private static Thread threadA;
    private static Thread threadB;
    public static int a = 0;

    @Override
    public void run() {
        for (int k = 0; k < 5; k++)
            a++;
    }

    public static void main(String[] args) {
        Runnable r = new ThreadJoinTest();
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);

        threadA = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println("[Thread-A] " + count++);
                    if (count == 50) {
                        try {
                            Thread.sleep(1);
                            threadB.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 100)
                        break;
                }
            }
        });
        threadA.start();

        threadB = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println("* [Thread-B] " + count++);
                    if (count == 1000)
                        break;
                }
            }
        });
        threadB.start();

    }
}
