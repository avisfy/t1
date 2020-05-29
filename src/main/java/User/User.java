package User;

public class User {
    String name;
    String surname;
    String date;
    String email;

    public User(String name, String surname, String date, String email) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
    }

    public void printUser() {
        System.out.println(name + " " + surname + " " + date + " " + email);
    }
}
