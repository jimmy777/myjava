package study1;

import java.util.Scanner;

public class ProductCodes {
    // 例子：11.3A
    public static void main(String[] args) {
        String code;
        char zone;
        int distict, valid = 0, banned = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter product code (XXX to quit): ");
        code = scan.nextLine();

        while (!code.equals("XXX")) {
            try {
                // charAt 抛出异常
                zone = code.charAt(9);
                // substring 抛出异常
                // parseInt 抛出异常
                distict = Integer.parseInt(code.substring(3, 7));
                // 正确的计数器增加1
                valid++;
                // 区域的计数器增加1
                if (zone == 'R' && distict > 2000)
                    banned++;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Improper code length: " + code);
            } catch (NumberFormatException e) {
                System.out.println("District is not numeric: " + code);
            }
            System.out.print("Enter product code (XXX to quit): ");
            code = scan.nextLine();

            System.out.println("# of valid codes entered: " + valid);
            System.out.println("# of banned codes entered: " + banned);
        }
    }
}
