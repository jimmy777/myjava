package libs;

public class StructureDemo {
    private int sId;
    private String sDate;

    public StructureDemo(int id, String date) {
        sId = id;
        sDate = date;
    }

    @Override
    public String toString() {
        return "ID: " + sId + "\t" + "DATE: " + sDate;
    }

    public int getsId() {
        return sId;
    }

    public String getsDate() {
        return sDate;
    }
}
