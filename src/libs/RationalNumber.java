package libs;

public class RationalNumber {
    private int numerator, denominator;

    public RationalNumber(int numer, int denom) {
        if (denom == 0)
            denom = 1;

        if (denom < 0) {
            numer = numer * -1;
            denom = denom * -1;
        }

        numerator = numer;
        denominator = denom;

        reduce();
    }

    @Override
    public String toString() {
        String result;
        if (numerator == 0)
            result = "0";
        else
            if (denominator == 1)
                result = numerator + "";
            else
                result = numerator + "/" + denominator;
        return result;
    }

    // 类内部使用的方法
    private void reduce() {
        if (numerator != 0) {
            int common = gcd(Math.abs(numerator), denominator);

            numerator = numerator / common;
            denominator = denominator / common;
        }
    }

    // 类内部使用的方法
    private int gcd(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        return num1;
    }

    // 两者是否相等？
    public boolean isLike(RationalNumber op2) {
        return (numerator == op2.getNumerator() && denominator == op2.getDenominator());
    }

    private int getDenominator() {
        return denominator;
    }

    private int getNumerator() {
        return numerator;
    }

    // 倒数
    public RationalNumber reciprocal() {
        return new RationalNumber(denominator, numerator);
    }

    // 相加
    public RationalNumber add(RationalNumber op2) {
        int commonDenominator = denominator * op2.getDenominator();
        int numerator1 = numerator * op2.getDenominator();
        int numerator2 = op2.getNumerator() * denominator;
        int difference = numerator1 + numerator2;

        return new RationalNumber(difference, commonDenominator);
    }

    // 减法
    public RationalNumber subtract(RationalNumber op2) {
        int commonDenominator = denominator * op2.getDenominator();
        int numerator1 = numerator * op2.getDenominator();
        int numerator2 = op2.getNumerator() * denominator;
        int difference = numerator1 - numerator2;

        return new RationalNumber(difference, commonDenominator);
    }

    // 乘法
    public RationalNumber multiply(RationalNumber op2) {
        int numer = numerator * op2.getNumerator();
        int denom = denominator * op2.getDenominator();

        return new RationalNumber(numer, denom);
    }

    public RationalNumber divide(RationalNumber op2) {
        // 除法，转换为乘与 op2 的倒数。
        return multiply(op2.reciprocal());
    }
}
