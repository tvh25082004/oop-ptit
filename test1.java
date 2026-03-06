

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }
}

class Student extends Person implements Introducible {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void introduce(String prefix) {
        System.out.println(
                prefix + " Tôi là sinh viên " + getName() +
                        ", mã SV: " + studentId +
                        ", " + getAge() + " tuổi.");
    }
    
}


interface Introducible {
    void introduce(String prefix);
}



class Teacher extends Person implements Introducible {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void introduce(String prefix) {
        System.out.println(
                prefix + " Tôi là giáo viên " + getName() +
                        ", dạy môn " + subject +
                        ", " + getAge() + " tuổi.");
    }
}

class Main {
    public static void main(String[] args) {

        // Khai báo đúng class thực tế → gọi được cả introduce lẫn setter
        Student p1 = new Student("An", 20, "SV001");
        Teacher p2 = new Teacher("Nam", 40, "Java");

        p1.setName("An Nguyen");
        p2.setAge(41);

        p1.introduce("Xin chào!");
        p2.introduce("Kính chào!");
    }
}