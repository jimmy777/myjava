package libs;

public class Grade {
    private String name;
    private int lowerBound;

    public Grade(String grade, int cutoff){
        name = grade;
        lowerBound = cutoff;
    }

    @Override
    public String toString() {
        return name + "\t" + lowerBound;
    }

    public void setName(String grade){
        name = grade;
    }

    public String getName() {
        return name;
    }

    public void setLowerBound(int cutoff) {
        this.lowerBound = cutoff;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}

