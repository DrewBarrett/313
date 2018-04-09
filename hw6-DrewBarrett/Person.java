/**
 * Person
 */
public class Person extends Cargo {

    private String name;
    private int age;

    public Person(String id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return super.toString() + ":\t"
            + "Name: " + name 
            + "\tAge: " + age;
    }
}