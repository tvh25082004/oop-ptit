class Main {

    static class Person {
        private String name;
        private String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() { return name; }
        public String getAddress() { return address; }

        @Override
        public String toString() {
            return name + " - " + address;
        }
    }

    static class Student extends Person {
        private int credits;

        public Student(String name, String address) {
            super(name, address);
            this.credits = 0;
        }

        public void study() {
            credits++;
        }

        public int credits() {
            return credits;
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(s);
        System.out.println("Study credits " + s.credits());
        s.study();
        System.out.println("Study credits " + s.credits());
    }
}