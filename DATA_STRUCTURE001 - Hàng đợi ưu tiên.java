import java.util.*;

class Student {
    String name;
    double cgpa;
    int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getId() { return id; }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {
            if (Double.compare(b.cgpa, a.cgpa) != 0)
                return Double.compare(b.cgpa, a.cgpa);
            if (!a.name.equals(b.name))
                return a.name.compareTo(b.name);
            return Integer.compare(a.id, b.id);
        });

        for (String event : events) {
            if (event.equals("SERVED")) {
                if (!pq.isEmpty()) pq.poll();
            } else {
                String[] parts = event.split(" ");
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.offer(new Student(name, cgpa, id));
            }
        }

        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll());
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) events.add(sc.nextLine().trim());

        Priorities p = new Priorities();
        List<Student> remaining = p.getStudents(events);

        if (remaining.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student s : remaining) System.out.println(s.getName());
        }
    }
}