package libs;

public class Contact implements Comparable<Contact> {
    // Comparable 是泛型接口。
    // Contact 实现了此接口。
    private String firstName;
    private String lastName;
    private String phone;

    public Contact(String first, String last, String telephone) {
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + "\t" + phone;
    }

    @Override
    public boolean equals(Object obj) {
        return (lastName.equals(((Contact) obj).getLastName()) &&
                firstName.equals(((Contact) obj).getFirstName()));
    }

    @Override
    public int compareTo(Contact o) {
        // 实现 compareTo 方法
        // 比较 firstname 再比较 lastname。
        int result;

        if (lastName.equals(o.getLastName()))
            result = firstName.compareTo(o.getFirstName());
        else
            result = lastName.compareTo(o.getLastName());

        return result;
    }
}
