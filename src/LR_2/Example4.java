package LR_2;

class Person {
    private String name;
    private int age;
    private String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    String getGender(){
        return gender;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setGender(String gender) {
        this.gender = gender;
    }
}

public class Example4 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30, "Female");
        System.out.printf("Person:\nName: %s, Age: %d, Gender: %s", person.getName(), person.getAge(), person.getGender());

        person.setAge(31);
        person.setName("Bob");
        person.setGender("Male");

        System.out.printf("\nUpdated Person:\nName: %s, Age: %d, Gender: %s", person.getName(), person.getAge(), person.getGender());
    }
}
