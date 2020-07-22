package study1;

import java.io.FileNotFoundException;

public class Base {

    // 第一部分（第1~6章节）的例子。

    enum Flavor { A, B, C};

    public static void main(String[] args) throws FileNotFoundException {

        // 例子: 变量与 final 常量
        /*
        System.out.println("第一行");
        System.out.println();
        System.out.println("word1"+","+"word2");
        System.out.println("转义：\t结束。");

        int total;
        int num1, num2=2, num3;
        final int MAX=45;

        System.out.println("第一行：" + total);
        System.out.println("第二行：" + num2);
        System.out.println("第三行：" + MAX);
        */

        // 例子: 变量与赋值
        /*
        int sides = 7;
        System.out.println("第一个值：" + sides);

        sides = 10;
        System.out.println("第二个值：" + sides);

        sides = 12;
        System.out.println("第二个值：" + sides);
         */

        // 例子: 整数和浮点型
        /*
        int answer = 12;
        byte smallNumber, smallNumber2;
        long countStars = 868L;
        float ratio = 0.21F;
        double delta = 0.12;

        System.out.println("整数为：" + answer);
        System.out.println("长整数为：" + countStars);
        System.out.println("浮点数为：" + ratio);
        System.out.println("双浮点：" + delta);
         */

        // 例子: 字符型
        /*
        char topGrade = 'A';
        char symball;
        char terminator=';', separator=' ';

        System.out.println("字符串" + topGrade);
        System.out.println("特殊字符" + terminator);
        System.out.println("特殊字符" + separator + "结束");
         */

        // 例子: 布尔值
        /*
        boolean flag = true;
        boolean tooHigh;
        boolean done = false;

        System.out.println("开" + flag);
        System.out.println("关" + done);
         */

        // 例子: 运算符
        /*
        final int BASE = 32;
        final double CONVERSION_FACTOR = 9.0 / 5.0;

        double fahrenheitTemp;
        int celsiusTemp = 24;

        fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;

        System.out.println("摄氏度：" + celsiusTemp);
        System.out.println("华氏度：" + fahrenheitTemp);
         */

        // 例子: 自增和自减运算符
        /*
        int i = 1, total;

        total = i++;
        System.out.println("i = "+i);
        System.out.println("total = "+total);

        System.out.println("-----------------");

        total = ++i;
        System.out.println("i = "+i);
        System.out.println("total = "+total);
         */

        // 例子: Scanner类
        /*
        String message;
        Scanner scan = new Scanner(System.in);

        System.out.println("输入一行文字：");
        message = scan.nextLine();
        System.out.println("你输入的文字是：\"" + message + "\"");

         */

        // 例子: String类
        /*
        String phrase = "Change is inevitable";
        String mutation1, mutation2,mutation3,mutation4;

        System.out.println("原字符串是" + phrase);
        System.out.println("原字符串长" + phrase.length());

        mutation1 = phrase.concat(", except from vending machines.");
        mutation2 = mutation1.toUpperCase();
        mutation3 = mutation2.replace('E', 'X');
        mutation4 = mutation3.substring(3, 30);

        System.out.println("字符串拼接" + mutation1);
        System.out.println("转换为大写" + mutation2);
        System.out.println("字母来替换" + mutation3);
        System.out.println("提取子串是" + mutation4);

         */

        // 例子: Random类
        /*
        Random generator = new Random();
        int num1;
        float num2;

        num1 = generator.nextInt();
        System.out.println("一个随机整数 " + num1);

        num1 = generator.nextInt(10);
        System.out.println("零到九的整数 " + num1);

        num1 = generator.nextInt(10) + 1;
        System.out.println("壹到拾的整数 " + num1);

        num2 = generator.nextFloat();
        System.out.println("零到壹的小数 " + num2);

        num2 = generator.nextFloat() * 6;
        System.out.println("零到六间小数 " + num2);
        num1 = (int)num2 + 1;
        System.out.println("壹到六的整数 " + num1);

         */

        // 例子: 解方程式 ax^2 + bx + c
        // 问题：联华超市将进货单价为40元的商品如果按50元销售，就能卖出500个，但如果这种商品每个涨价1元，其销售量就减少10个，如果你是超市的经理的话，为了赚得8000元的利润，你觉得售价应定为多少？这时应进货多少个？
        // 分析：题中如果销售价按照单价50元的话，每个利润是10元，可以卖出500个，共可获利5000元，无法完成利润8000元的目标，所以只有提高单价并控制适当的单价，才可以完成获得利润5000元任务。
        // 解题：x^2 -40x + 300 = 0
        // 计算 x1 和 x2
        /*
        int a,b,c;
        double disciminant, x1, x2;

        Scanner scanner = new Scanner(System.in);

        // a=1
        System.out.println("输入a ");
        a = scanner.nextInt();

        // b=-40
        System.out.println("输入b ");
        b = scanner.nextInt();

        // c=300
        System.out.println("输入c ");
        c = scanner.nextInt();

        // b^2-4ac
        // (-40)^2-4*1*300=400
        disciminant = Math.pow(b, 2) - (4*a*c);
        System.out.println("因子1：" + disciminant);

        // Math类的开根号，得到第一个值x1。
        x1 = ((-1*b) + Math.sqrt(disciminant)) / (2*a);
        System.out.println("定价因子1：" + x1 + "，定价为：" + (50+x1) + "，进货量为：" + (int)(500-(10*x1)));

        // Math类的开根号，得到第二个值x2。
        x2 = ((-1*b) - Math.sqrt(disciminant)) / (2*a);
        System.out.println("定价因子2：" + x2 + "，定价为：" + (50+x2) + "，进货量为：" + (int)(500-(10*x2)));

         */

        // 例子: NumberFormat格式化
        /*
        final double TAX_RATE = 0.06; // 6%的税

        int quantity; // 销售数量
        double subtotal, tax, totalCost, unitPrice;

        Scanner scanner = new Scanner(System.in);

        NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
        NumberFormat fmt2 = NumberFormat.getPercentInstance();

        System.out.println("输入销售的数量：");
        quantity = scanner.nextInt();

        System.out.println("输入商品单价：");
        unitPrice = scanner.nextDouble();

        subtotal = quantity * unitPrice; // 销售额
        tax = subtotal * TAX_RATE; // 税
        totalCost = subtotal + tax; // 成本

        System.out.println("销售额为：" + fmt1.format(subtotal));
        System.out.println("交税额为：" + fmt1.format(tax) + "，按 " + fmt2.format(TAX_RATE) + " 税率来计算");
        System.out.println("总成本为：" + fmt1.format(totalCost));

         */

        // 例子: DecimalFormat类
        /*
        int radius;
        double area, circumference;

        Scanner scan = new Scanner(System.in);

        System.out.println("输入半径:");
        radius = scan.nextInt();

        area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;

        DecimalFormat fmt = new DecimalFormat("0.###");


        System.out.println("它面积为：" + fmt.format(area));
        System.out.println("它周长为：" + fmt.format(circumference));

         */

        // 例子: 枚举类型
        /*
        Flavor cone1, cone2, cone3;

        cone1 = Flavor.B;

        System.out.println("cone1 值：" + cone1);
        System.out.println("cone1 序：" + cone1.ordinal());
        System.out.println("cone1 名：" + cone1.name());

         */

        // 例子: switch运算符
        // 说明: 如果是连续区间建议if支持整数或枚举，如果是离散的单点值建议 switch 不支持小数.
        /*
        int rank = 20;
        switch (rank){ //遇到break或最后}跳出结束
            case 10: //不能重复
                System.out.println("正数奖励笔记本");
                break;
            case 20:
                System.out.println("奖励U盘");
                break;//一般建议不省略
            case 30:
                System.out.println("不奖励");
        }

         */

        // 例子: 两个骰子
        /*
        Die die1, die2;
        int sum;

        die1 = new Die();
        die2 = new Die();

        die1.roll();
        die2.roll();

        System.out.println("骰子1：" + die1 + ", 骰子2：" + die2) ;

        die1.roll();
        die2.setFaceValue(4);

        System.out.println("骰子1：" + die1 + ", 骰子2：" + die2) ;

        sum = die1.getFaceValue() + die2.getFaceValue();
        System.out.println("结果是：" + sum);

         */

        /*
        // 例子: 4.4.4 银行账户示例
        // 功能: 1. 账户实例包括：客户、账户号、当前余额。
        // 2. deposit和withdraw 两个方法执行账户的交易，并调整余额。
        // 3. addInterest计算利息，加入余额。
        Account acct1 = new Account("Ted Murphy", 72354, 102.56);
        Account acct2 = new Account("Jane Smith", 69713, 40.00);
        Account acct3 = new Account("Edward Demsey", 93757, 759.32);

        acct1.deposit(25.85);

        double smithBalance = acct2.deposit(500.00);
        System.out.println("Smith balance after deposit: " + smithBalance);
        System.out.println("Smith balance after withdrawal: " + acct2.withdraw(430.75, 1.50));

        acct1.addInterest();
        acct2.addInterest();
        acct3.addInterest();

        System.out.println();
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);

        */

        // 例子: 5.2A
        // 功能: 根据年龄 MINOR 判断,显示不同的内容.
        /*
        final int MINOR = 21;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scan.nextInt();

        System.out.println("You entered: " + age);
        if(age < MINOR)
            System.out.println("Youth is a wonderful thing. Enjoy.");

        System.out.println("Age is a state of mind.");
        */

        // 例子: 5.2B 计算员工的工资
        // 功能: 判断是否一周是否超过 40 小时,超过的部分按 1.5 倍来计算.
        /*
        final double RATE = 8.25;
        final int STANDARD = 40;

        Scanner scan = new Scanner(System.in);

        double pay = 0.0;

        System.out.print("Enter the number of hours worded: ");
        int hours = scan.nextInt();
        System.out.println();

        if (hours > STANDARD)
            pay = STANDARD * RATE + (hours - STANDARD) *  (RATE * 1.5);
        else
            pay = hours * RATE;

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Gross earnings: " + fmt.format(pay));
        */

        // 例子: 5.2C 掷硬币
        // 功能: flip 方法来掷硬币
        /*
        Coin coin = new Coin();

        coin.flip();

        System.out.println(coin);

        if (coin.isHeads())
            System.out.println("You win.");
        else
            System.out.println("Better luck next time.");
        */

        // 例子: 5.2D Guessing
        // 功能: 猜数,如果两个数一致则赢,否则失败.
        /*
        final int MAX = 10;
        int answer, guess;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        answer = random.nextInt(MAX) + 1;

        System.out.print("I'm thinking of a number between 1 and " + MAX + ". Guess what it is: ");

        guess = scanner.nextInt();

        if (answer == guess)
            System.out.println("You got it! Good guessing!");
        else {
            System.out.println("That is not correct. sorry.");
            System.out.println("The number was " + answer);
        }
        */

        // 例子: 5.2E MinOfThree
        // 功能: 用户输入三个数,判断其中最小的一个.
        /*
        int num1, num2, num3, min = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three integers: ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        if (num1 < num2)
            if (num1 < num3)
                min = num1;
            else
                min = num3;
        else
            if (num2 < num3)
                min = num2;
            else
                min = num3;

        System.out.println("Minimum value: " + min);
        */

        // 例子: 5.4A Average
        // 功能: 用户输入一系列整数,计算它们的平均值.
        // 说明: 用户输入多少次用 count 来计数.sum 用于累加和.要防止count为0,这样会除0错误.
        /*
        int sum = 0, value, count = 0;
        double average;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer (0 to quit): ");
        value = scanner.nextInt();

        while (value != 0) {
            count++;

            sum += value;
            System.out.println("The sum so far is " + sum);

            System.out.println("Enter an Integer (0 to quit): ");
            value = scanner.nextInt();
        }

        System.out.println();

        if (count == 0)
            System.out.println("No values were entered.");
        else {
            average = (double)sum / count;

            DecimalFormat fmt = new DecimalFormat("0.###");
            System.out.println("The average is " + fmt.format(average));
        }
        */

        // 例子: 5.4B WinPercentage
        // 功能: 猜胜率.
        /*
        final int NUM_GAMES = 12;
        int won;
        double ratio;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of games won (0 to " + NUM_GAMES + "): ");
        won = scanner.nextInt();

        if (won < 0 || won > NUM_GAMES) {
            System.out.print("Invaild input. Please reenter: ");
            won = scanner.nextInt();
        }

        ratio = (double)won / NUM_GAMES;

        NumberFormat fmt = NumberFormat.getPercentInstance();

        System.out.println();
        System.out.println("Winning percentage: " + fmt.format(ratio));
        */

        // 例子: 5.4C PalindromeTester
        // 功能: 回文字符串的判断,如 radar.
        /*
        String str, another = "y";
        int left, right;

        Scanner scanner = new Scanner(System.in);

        // allows y or Y
        while (another.equalsIgnoreCase("y")) {
            System.out.println("Enter a potential palindrome: ");
            str = scanner.nextLine();

            left = 0;
            right = str.length() - 1;

            while (str.charAt(left) == str.charAt(right) && left < right) {
                left++;
                right--;
            }

            System.out.println();

            if (left < right)
                System.out.println("That string is NOT a palindrome.");
            else
                System.out.println("That string IS a palindrome.");

            System.out.println();
            System.out.println("Test another palindrome (y/n)?");
            another = scanner.nextLine();
        }
         */

        // 例子: 5.5A URLDissector
        // 功能: 利用迭代器,读取并处理 URL 串.
        /*
        String url;
        Scanner fileScan, urlScan;

        // Scanner 读取文件
        fileScan = new Scanner(new File("urls.inp"));

        // 判断是否有行记录了?
        while (fileScan.hasNext()){
            // 读取一行,保存到 url 中
            url = fileScan.nextLine();
            System.out.println("URL: " + url);

            // 读取一行记录到 curlScan 中,分割符为 /
            urlScan = new Scanner(url);
            urlScan.useDelimiter("/");

            while (urlScan.hasNext())
                System.out.println(" " + urlScan.next());

            System.out.println();
        }
        */

        // 例子: 5.6A Beatles
        // 功能: ArrayList 对象操作.
        /*
        ArrayList<String> band = new ArrayList<>();

        band.add("Paul");
        band.add("Pete");
        band.add("John");
        band.add("George");

        System.out.println(band);

        int location = band.indexOf("Pete");
        band.remove(location);
        System.out.println(band);

        System.out.println("At index 1: " + band.get(1));
        band.add(2, "Ringo");
        System.out.println(band);

        System.out.println("Size of band: " + band.size());

        int index = 0;
        while (index < band.size()){
            System.out.println(band.get(index));
            index++;
        }
         */

        // 例子： 6.1A GradeReport
        // 功能： 根据输入的成绩（0~100），来判断成绩的等级。
        /*
        int grade, category;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a numeric grade (0 to 100): ");
        grade = scan.nextInt();

        category = grade / 10;

        System.out.print("That grade is ");

        switch (category){
            case 10:
                System.out.println("a perfect score. Well done.");
                break;
            case 9:
                System.out.println("well above average. Excellent.");
                break;
            case 8:
                System.out.println("above average. Nice job.");
                break;
            case 7:
                System.out.println("average.");
                break;
            case 6:
                System.out.println("below average. You should see the");
                System.out.println("instructor to clarify the material " + "presented in class.");
                break;
            default:
                System.out.println("not passing.");
        }
         */

        // 例子：6.2A ReverseNumber
        // 功能：输入数字，输出反序数字。
        /*
        int number, lastDigit, reverse = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        number = scan.nextInt();

        do {
            lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number = number / 10;
        } while (number > 0);

        System.out.println("That number reversed is " + reverse);
         */

        // 例子：6.4A Multiples
        // 功能：用户输入两个数，这两个之间的数，每次都增加第一个数，知道不超过第二个数。
        // 每5个数换一行
        /*
        final int PER_LINE = 5;
        int value, limit, mult, count = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a positive value: ");
        value = scan.nextInt();

        System.out.print("Enter an upper limit: ");
        limit = scan.nextInt();

        System.out.println();
        System.out.println("The multiples of " + value + " between " +
                value + " and " + limit + " (inclusive) are: ");

        for (mult = value; mult <= limit; mult += value) {
            System.out.print(mult + "\t");
            count++;
            if (count % PER_LINE == 0)
                System.out.println();
        }
         */

        // 例子：6.4B Stars
        // 功能：打印三角形。

        final int MAX_ROWS = 10;

        for (int row=1; row<=MAX_ROWS; row++){
            for (int star=1; star<=row;star++)
                System.out.print("*");
            System.out.println();
        }

        // 结束
    }
}
