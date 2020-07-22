package libs;

// 还可以获得奖金的员工，继承至员工类。
public class Executive extends Employee {
    private double bonus; // 奖金 bonus


    public Executive(String name, String address, String phone, String socialSecurityNumber, double payRate) {
        // 先初始化父类 Employee，再初始化本类。
        super(name, address, phone, socialSecurityNumber, payRate);
        this.bonus = 0;
    }

    // 奖励奖金
    public void awardBonus(double execBonus){
        bonus = execBonus;
    }

    @Override
    public double pay() {
        // 重写父类的 pay 函数。
        // 父类 Employee 类的 pay 方法后，再加上奖金。
        // 注意，这块没有直接使用 Employee 类的 payRate 变量，这样 Employee 类的 pay 计算方法变化了，直接影响子类 pay 函数计算方法。
        double payment = super.pay() + bonus;

        bonus = 0;
        return payment;
    }
}
