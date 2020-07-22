package study1;

public class Primes {

    // 例子：8.2.3A Primes数组初始化表
    public static void main(String[] args) {
        int[] primeNums = {2, 3, 5, 6, 11, 13, 17, 19};

        System.out.println("Array length: " + primeNums.length);

        System.out.println("The first few prime numbers are:");

        for (int prime: primeNums)
            System.out.print(prime + "\t");
    }
}
