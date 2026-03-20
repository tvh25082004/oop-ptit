// Abstract cha
abstract class LivingThing {
    private String name;

    public LivingThing(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void breathe();
    public abstract void eat();
}

// Abstract con 
abstract class Person extends LivingThing {
    private int age;

    public Person(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() { return age; }

    public void setName(String name) {
        // gọi lại setter thông qua field của LivingThing không được
        // nên override getName() hoặc thêm field riêng
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " đang thở bằng phổi.");
    }

    // eat() chưa implement → để Student/Teacher xử lý

    public abstract void introduce(String prefix);
}

// Class Student - implement TẤT CẢ abstract còn lại
class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " đang ăn cơm.");
    }

    @Override
    public void introduce(String prefix) {
        System.out.println(
                prefix + " Tôi là sinh viên " + getName() +
                        ", mã SV: " + studentId +
                        ", " + getAge() + " tuổi.");
    }
}

// Class Teacher - implement TẤT CẢ abstract còn lại
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " đang ăn phở.");
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

        Person p1 = new Student("An", 20, "SV001");
        Person p2 = new Teacher("Nam", 40, "Java");

        p1.setAge(21);
        p2.setAge(41);

        p1.breathe();              // từ Person
        p1.eat();                  // từ Student
        p1.introduce("Xin chào!");

        System.out.println("---");

        p2.breathe();              // từ Person
        p2.eat();                  // từ Teacher
        p2.introduce("Kính chào!");
    }
}
```

---

### Chuỗi kế thừa hoàn chỉnh
```
LivingThing (abstract)
│   breathe() ← abstract
│   eat()     ← abstract
│
└── Person (abstract) extends LivingThing
│   breathe() ← ✅ đã implement
│   eat()     ← ❌ chưa implement
│   introduce() ← abstract mới
│
├── Student extends Person
│   eat()       ← ✅ implement
│   introduce() ← ✅ implement
│
└── Teacher extends Person
    eat()       ← ✅ implement
    introduce() ← ✅ implement