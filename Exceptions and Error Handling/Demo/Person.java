public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        //нов празен обект
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < 2) {
            throw new NullPointerException("Name has to be at least 2 letters");
        }
        //name.length() >= 2
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age has to be more than 0.");
        }
        //age > 0
        this.age = age;
    }
}
