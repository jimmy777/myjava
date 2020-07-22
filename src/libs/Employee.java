package libs;

// 员工类，特征是有社保卡号和工资。
public class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone, String socialSecurityNumber, double payRate) {
        super(name, address, phone);
        this.socialSecurityNumber = socialSecurityNumber;
        this.payRate = payRate;
    }

    @Override
    public String toString() {
        String result = super.toString(); // 显示了父类的基本信息。
        result += "\nSocial Security Number: " + socialSecurityNumber; // 显示多了社保卡号

        return result;
    }

    @Override
    public double pay() {
        return payRate; // 员工类的 pay 方法，返回薪资水平。
    }
}
