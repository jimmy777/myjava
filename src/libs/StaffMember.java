package libs;

// 抽象类，其他4个类的祖先。
abstract public class StaffMember {
    protected String name;
    protected String address;
    protected String phone;


    // 构造函数，定义了4个基本信息。
    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        String result = "Name: "+name+"\n";
        result += "Address: "+address+"\n";
        result += "Phone: "+ phone;

        return result;
    }

    // 抽象函数 pay，由继承的4个子类去实现。
    public abstract double pay();
}
