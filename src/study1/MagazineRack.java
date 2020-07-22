package study1;

import libs.Magazine;
import libs.MagazineList;

public class MagazineRack {
    // 例子 13.2.2A
    public static void main(String[] args) {
        MagazineList rack = new MagazineList();

        rack.add(new Magazine("Time"));
        rack.add(new Magazine("Woodworking Today"));
        rack.add(new Magazine("Communications of the ACM "));
        rack.add(new Magazine("House and Garden"));
        rack.add(new Magazine("GQ"));

        System.out.println(rack);
    }
}
