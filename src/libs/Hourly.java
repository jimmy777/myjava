package libs;

// 钟点工类，基本信息 + 小时计费工资
public class Hourly extends Employee {
    private int hoursWorked; // 工时

    public Hourly(String name, String address, String phone, String socialSecurityNumber, double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate); // 调用父类 Employee 的构造函数
        this.hoursWorked = 0;
    }

    // 增加工时
    public void addHours(int moreHours) {
        hoursWorked += moreHours;
    }

    @Override
    public double pay() {
        double payment = payRate * hoursWorked; // 重写计算薪资函数 pay
        hoursWorked = 0;

        return payment;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nCurrent hours: " + hoursWorked; // 重写小时工的显示项

        return result;
    }
}
