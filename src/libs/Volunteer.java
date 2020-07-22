package libs;

// 自愿者类，只有基本信息且工资是0.
public class Volunteer extends StaffMember {
    // 自愿者只有基本信息。
    public Volunteer(String eName, String eAddress, String ePhone) {
        super(eName, eAddress,ePhone);
    }

    @Override
    public double pay() {
        return 0.0; // 自愿者工资是0
    }
}
