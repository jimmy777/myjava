package libs;

import java.text.NumberFormat;

// DVD 集合类的结构。
public class DVDCollection {
    private DVD[] collection;
    private int count;
    private double totalCost;

    public DVDCollection() {
        // 初始100张DVD。
        collection = new DVD[100];
        count = 0;
        totalCost = 0.0;
    }

    public void addDVD(String title, String director, int year, double cost, boolean bluray) {
        if (count == collection.length)
            increaseSize();

        collection[count] = new DVD(title, director, year, cost, bluray);
        totalCost += cost;
        count++;
    }

    // 100张DVD已满后，对象数组长度扩展一倍。
    private void increaseSize() {
        DVD[] temp = new DVD[collection.length * 2];
        for (int dvd = 0; dvd < collection.length; dvd++)
            temp[dvd] = collection[dvd];
        collection = temp;
    }

    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String report = "-------------------------------\n";
        report += "My DVD Collection\n\n";

        report += "Number of DVDs: " + count + "\n";
        report += "Total cost: " + fmt.format(totalCost) + "\n";
        report += "Average cost: " + fmt.format(totalCost / count);

        report += "\n\nDVD List:\n\n";

        for (int dvd = 0; dvd < count; dvd++)
            report += collection[dvd].toString() + "\n";

        return report;
    }
}