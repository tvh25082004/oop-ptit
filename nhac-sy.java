import java.util.Scanner;

class Musician {
    private String name;
    private String nationality; // only "VN" or "INT"
    private String style;

    public Musician(String name, String nationality, String style) {
        this.name = name;
        this.nationality = nationality;
        this.style = style;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Musician[name=" + name
                + ", nationality=" + nationality
                + ", style=" + style + "]";
    }
}

class Song {
    private String title;
    private String genre;
    private int year;
    private Musician musician;

    public Song(String title, String genre, int year, Musician musician) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.musician = musician;
    }

    @Override
    public String toString() {
        return "Song[title=" + title
                + ", genre=" + genre
                + ", year=" + year
                + ", " + musician + "]";
    }
}

class Main {
    private static boolean isValidNationality(String n) {
        return "VN".equals(n) || "INT".equals(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String musicianName = sc.nextLine();
        String nationality = sc.nextLine();
        String style = sc.nextLine();
        String title = sc.nextLine();
        String genre = sc.nextLine();
        int year = Integer.parseInt(sc.nextLine().trim());

        // Validate nationality
        if (!isValidNationality(nationality)) {
            System.out.println("Invalid nationality. Only 'VN' or 'INT' allowed.");
            sc.close();
            return;
        }

        Musician musician = new Musician(musicianName, nationality, style);
        Song song = new Song(title, genre, year, musician);

        System.out.println(song);

        sc.close();
    }
}