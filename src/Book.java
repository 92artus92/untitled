public class Book {

    private String title, author;
    private int year;
    private boolean wypozyczenie;

    public Book(String tle, String ath, int yr) {
        this.title = tle;
        this.author = ath;
        this.year = yr;
        wypozyczenie = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean dostepnoscKsiazki() {
        return wypozyczenie;
    }

    public void wypozycznieIOddawanieKsiazki(Boolean set) {
        wypozyczenie = set;
    }

    @Override
    public String toString() {
        return "\nTytul: " + title + "\nAutor: " + author + "\nRok wydania: " + year + "\nDostepnosc: " + wypozyczenie + "\n";
    }

}
