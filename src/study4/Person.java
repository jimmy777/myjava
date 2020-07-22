package study4;

public class Person {

    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void talk(String msg){
        System.out.println("说话： " + msg);
    }

    private void walk(int step){
        System.out.println("走路： " + step + " 步");
    }

    protected void dance(boolean skill) {
        if (skill)
            System.out.println("技能：会跳舞");
        else
            System.out.println("技能：不会跳舞");
    }
}
