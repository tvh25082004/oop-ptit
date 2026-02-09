
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter (Encapsulation)
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    // Abstraction
    public abstract void introduce();
}

class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void introduce() {
        System.out.println(
            "Tôi là sinh viên " + getName() +
            ", mã SV: " + studentId +
            ", " + getAge() + " tuổi."
        );
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        System.out.println(
            "Tôi là giáo viên " + getName() +
            ", dạy môn " + subject +
            ", " + getAge() + " tuổi."
        );
    }
}

class Main {

    public static void main(String[] args) {
        
        // Polymorphism
        Person p1 = new Student("An", 20, "SV001");
        Person p2 = new Teacher("Nam", 40, "Java");

        p1.setName("An Nguyen");
        p2.setAge(41);

        p1.introduce();
        p2.introduce();
    }
}

