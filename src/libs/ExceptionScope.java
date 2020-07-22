package libs;

public class ExceptionScope {
    public void level1(){
        System.out.println("Level 1 beginning.");

        try{
            // 获取 Level 3 抛出的异常，并处理。
            level2();
        } catch (ArithmeticException e) {
            System.out.println();
            System.out.println("The exception message is: " + e.getMessage());
            System.out.println();
            System.out.println("The call stack trace: ");
            e.printStackTrace();
            System.out.println();
        }

        System.out.println("Level 1 ending.");
    }

    private void level2() {
        System.out.println("Level 2 beginning.");
        // 异常没有处理，继续向上传递给 Level 1.
        level3();
        System.out.println("Level 2 ending.");
    }

    private void level3() {
        int numerator =10, denominator =0;

        System.out.println("Level 3 beginning.");
        // 抛出异常，但不处理。传递给 Level 2.
        int result = numerator / denominator;
        System.out.println("Level 3 ending.");
    }


}
