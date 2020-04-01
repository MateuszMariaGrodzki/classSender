package classRepository;

public class Human {
    private String name;
    private String surname;
    private String pesel;
    private int age;
    private String email;

    public Human(String name, String surname, String pesel, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
