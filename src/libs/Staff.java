package libs;

// 公司雇员
public class Staff {

    // 维护了一个对象 StaffMember 数组。
    private StaffMember[] staffList;

    public Staff() {
        // StaffMember 是一个抽象类，另4个类是其后代。
        staffList = new StaffMember[6];

        // staffList 数组分别存入了 4 类不同的对象。--> 实现多态性
        // Executive 对象
        staffList[0] = new Executive("Sam","123 Main Line","555-0469","123-45-6789",2423.07);
        // Executive 对象
        staffList[1] = new Employee("Carla","456 Off Line", "555-0101", "987-65-4321", 1246.15);
        staffList[2] = new Employee("Woody","7889 Off Rocker", "555-0000", "010-20-3040", 1169.23);
        // Hourly 对象
        staffList[3] = new Hourly("Diane", "678 Firth Ave.","555-0690","958-47-3625",10.55);
        // Volunteer 对象
        staffList[4] = new Volunteer("Norm","987 Suds Blvd.", "555-8374");
        staffList[5] = new Volunteer("Cliff","321 Duds Lane", "555-7282");

        ((Executive)staffList[0]).awardBonus(500.00); // StaffMember 类没有 awardBonus 方法，必须转换为 Executive 对象。
        ((Hourly)staffList[3]).addHours(40); // 同样，StaffMember 类没有 addHours 方法，必须转换为 Hourly 对象。
    }

    public void payday(){
        double amount; // 员工薪资

        for (int count=0;count<staffList.length;count++){
            System.out.println(staffList[count]);
            // 每个类都由 pay 方法的实现。 --> 实现多态性。
            amount = staffList[count].pay();

            if (amount == 0.0)
                // 自愿者的工资是0，所以输出一个信息。
                System.out.println("Thank!");
            else
                System.out.println("Paid: "+amount);

            System.out.println("----------------------------");
        }
    }
}
