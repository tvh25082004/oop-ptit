import java.util.*;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        setGender(gender);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public char getGender() { return gender; }
    public void setGender(char gender) {
        if (gender == 'f' || gender == 'm') this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    @Override
    public String toString() {
        return "Book[name=" + name + ", " + author.toString() + ", price=" + price + ", qty=" + qty + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());

        for (int t = 0; t < T; t++) {
            String type = sc.nextLine().trim();

            if (type.equals("Book")) {
                String bookName = sc.nextLine().trim();
                double price = Double.parseDouble(sc.nextLine().trim());
                int qty = Integer.parseInt(sc.nextLine().trim());

                String authorType = sc.nextLine().trim(); // "Author"
                String authorName = sc.nextLine().trim();
                String email = sc.nextLine().trim();
                char gender = sc.nextLine().trim().charAt(0);

                Author author = new Author(authorName, email, gender);
                Book book = new Book(bookName, author, price, qty);
                System.out.println(book);
            }
        }

        // Đọc "End"
        if (sc.hasNextLine()) sc.nextLine();
    }
}