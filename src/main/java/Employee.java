public class Employee {

    // add fields
    // name, surname, year, role
    // all args constructor + no args constructor
    // getter/setter
    // test in under test/java package
    // goal: 100% coverage

    public String name;
    public String surname;
    public int age;
    public String role;

    public Employee(String name, String surname, int age, String role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.role = role;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
