package libs;

public class Family {

    private String[] members;

    public Family(String ... names) {
        members = names;
    }

    @Override
    public String toString() {
        String result = "";

        for (String name: members) {
            result += name + "\n";
        }
        return result;
    }
}
