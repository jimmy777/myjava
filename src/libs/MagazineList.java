package libs;

public class MagazineList {
    // 提供了一组方法，用户维护列表，如 add 方法等，定义对接口的操作。
    private MagazineList  list;

    public MagazineList(){
        list = null;
    }

    public void add(Magazine mag){
        MagazineNode node = new MagazineNode(mag);
        MagazineNode current;

        if (list == null) {
            current = node;
        }
        else{
            current = null;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }

    }

    @Override
    public String toString() {
        String result = "";

        MagazineNode current = list;

        while (current != null){
            result += current.magazine + "\n";
            current = current.next;
        }
        return result;
    }

    // 定义一个内部类，代表链表中的一个节点。
    // 链表类可以直接使用内部类中的数据。
    private class MagazineNode {
        public Magazine magazine; // 杂志对象
        public MagazineNode next; // 下一个节点的对象引用

        public MagazineNode(Magazine mag) {
            magazine = mag;
            next = null;
        }
    }
}
