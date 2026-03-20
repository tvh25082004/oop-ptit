// ================================================================
// DESIGN PATTERNS - Demo với Person, Student, Teacher
// ================================================================

// ================================================================
// 1. SINGLETON PATTERN
// Đảm bảo chỉ có 1 instance duy nhất (ví dụ: 1 hiệu trưởng)
// ================================================================

class Principal {
    private static Principal instance; // instance duy nhất
    private String name;

    private Principal() { // private → không cho new từ ngoài
        this.name = "Hiệu Trưởng Nguyễn Văn A";
    }

    public static Principal getInstance() {
        if (instance == null) {
            instance = new Principal();
        }
        return instance;
    }

    public String getName() { return name; }
}

// ================================================================
// 2. FACTORY PATTERN
// Tạo object mà không cần biết class cụ thể bên trong
// ================================================================

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        System.out.println("[Student] Tôi là " + name + ", mã SV: " + studentId + ", " + age + " tuổi.");
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
        System.out.println("[Teacher] Tôi là " + name + ", dạy môn: " + subject + ", " + age + " tuổi.");
    }
}

// Factory - nơi tạo object
class PersonFactory {
    public static Person create(String type, String name, int age, String extra) {
        if (type.equals("student")) {
            return new Student(name, age, extra);
        } else if (type.equals("teacher")) {
            return new Teacher(name, age, extra);
        }
        throw new IllegalArgumentException("Không biết type: " + type);
    }
}

// ================================================================
// 3. OBSERVER PATTERN
// Khi 1 sự kiện xảy ra → tất cả người đăng ký đều được thông báo
// ================================================================

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class SchoolNotification {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notify(String message) {
        System.out.println("\n📢 Thông báo: " + message);
        for (Observer o : observers) {
            o.update(message);
        }
    }
}

class StudentObserver implements Observer {
    private String name;

    public StudentObserver(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("  [Student - " + name + "] nhận được: " + message);
    }
}

class TeacherObserver implements Observer {
    private String name;

    public TeacherObserver(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("  [Teacher - " + name + "] nhận được: " + message);
    }
}

// ================================================================
// 4. STRATEGY PATTERN
// Thay đổi hành vi (thuật toán) linh hoạt lúc runtime
// ================================================================

interface StudyStrategy {
    void study(String name);
}

class OnlineStudy implements StudyStrategy {
    @Override
    public void study(String name) {
        System.out.println(name + " đang học online qua Zoom.");
    }
}

class OfflineStudy implements StudyStrategy {
    @Override
    public void study(String name) {
        System.out.println(name + " đang học trực tiếp tại lớp.");
    }
}

class SelfStudy implements StudyStrategy {
    @Override
    public void study(String name) {
        System.out.println(name + " đang tự học tại nhà.");
    }
}

class StudentStrategy {
    private String name;
    private StudyStrategy strategy;

    public StudentStrategy(String name, StudyStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void setStrategy(StudyStrategy strategy) {
        this.strategy = strategy; // đổi chiến lược lúc runtime
    }

    public void study() {
        strategy.study(name);
    }
}

// ================================================================
// MAIN - Chạy tất cả patterns
// ================================================================

class Main {
    public static void main(String[] args) {

        // ---- 1. SINGLETON ----
        System.out.println("========== SINGLETON ==========");
        Principal p1 = Principal.getInstance();
        Principal p2 = Principal.getInstance();
        System.out.println(p1.getName());
        System.out.println("p1 == p2 ? " + (p1 == p2)); // true → cùng 1 instance

        // ---- 2. FACTORY ----
        System.out.println("\n========== FACTORY ==========");
        Person s = PersonFactory.create("student", "An", 20, "SV001");
        Person t = PersonFactory.create("teacher", "Nam", 40, "Java");
        s.introduce();
        t.introduce();

        // ---- 3. OBSERVER ----
        System.out.println("\n========== OBSERVER ==========");
        SchoolNotification school = new SchoolNotification();

        StudentObserver sv1 = new StudentObserver("An");
        StudentObserver sv2 = new StudentObserver("Bình");
        TeacherObserver gv1 = new TeacherObserver("Nam");

        school.subscribe(sv1);
        school.subscribe(sv2);
        school.subscribe(gv1);

        school.notify("Nghỉ học ngày mai!");

        school.unsubscribe(sv2); // Bình hủy đăng ký
        school.notify("Thi cuối kỳ tuần sau!");

        // ---- 4. STRATEGY ----
        System.out.println("\n========== STRATEGY ==========");
        StudentStrategy student = new StudentStrategy("An", new OnlineStudy());
        student.study(); // học online

        student.setStrategy(new OfflineStudy());
        student.study(); // chuyển sang học offline

        student.setStrategy(new SelfStudy());
        student.study(); // chuyển sang tự học
    }
}

// ---

// ### Tóm tắt 4 patterns
// ```
// SINGLETON  → Chỉ 1 instance duy nhất
//              VD: 1 hiệu trưởng, 1 database connection

// FACTORY    → Tạo object linh hoạt không cần biết class cụ thể
//              VD: tạo Student hoặc Teacher chỉ bằng 1 dòng

// OBSERVER   → Thông báo tự động đến tất cả người đăng ký
//              VD: trường thông báo → student + teacher đều nhận

// STRATEGY   → Đổi hành vi linh hoạt lúc chạy
//              VD: học online → offline → tự học, không cần sửa code