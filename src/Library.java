import java.util.*;

public class Library {

    private Map<Integer, Book> lib;
    Scanner in = new Scanner(System.in);
    private int id = 10;

    public Library() {
        lib = new HashMap<Integer, Book>();
    }

    public void addBook(Book book) {

        lib.put(id, book);
        id = id + 1;
    }

    public void availabilityOfABook(int idKsiazki){

        for(Book temp: lib.values()){

            if ((lib.containsKey(idKsiazki)) && (temp.dostepnoscKsiazki() == true)) {
                System.out.println(temp.toString());
                System.out.println("Czy na pewno chcesz ja wypozyczyc ? (y/n)");
                if(in.next().equalsIgnoreCase("y")){temp.wypozycznieIOddawanieKsiazki(false);}
                break;
            }
            else {System.out.println("Ksiazki nie ma w systemie lub jest wypozyczona");
                break;}
        }
    }

    public void displayLibrary() {

        Set set = lib.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println("Key is: " + me.getKey() + "\nValue is: " + me.getValue());
        }
    }

    public void usunKsiazke(int usunID){

        if((lib.containsKey(usunID)) && !(lib.get(usunID).dostepnoscKsiazki() == false)) {
            lib.remove(usunID);
            System.out.println("Pozycja uusunieta");
        }
        else {
            System.out.println("Nie ma ksiazki z takim ID lub jest wypozyczona");
        }
    }

    public void searchTitle(int szukane) {

        if (lib.containsKey(szukane)){ System.out.println(lib.get(szukane).toString()); }
        else { System.out.println("Nie ma ksiazki o podanym ID");}
    }

    public void searchTitle(String sTitle) {

        for (Book temp : lib.values()) {
            if (temp.getTitle().equalsIgnoreCase(sTitle)) {
                System.out.println(temp.toString());
                break;
            } else System.out.println("Nie ma ksiazki o podanym tytule");
        }
    }

    public void searchTitleAuthor(String author) {

        for (Book temp : lib.values()) {
            if (temp.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(temp.toString());
                break;
            } else System.out.println("Nie ma ksiazki podanego autora");
        }
    }

    public void searchTitleYear(int year) {

        for (Book temp : lib.values()) {
            if (temp.getYear() == year) {
                System.out.println(temp.toString());
                break;
            } else System.out.println("Nie ma ksiazki o podanym tytule");
        }
    }

    public void oddawanieKsiazki(int idOddawanie){

        if (lib.containsKey(idOddawanie)){
            lib.get(idOddawanie).wypozycznieIOddawanieKsiazki(true);
            System.out.println("Zwrot ksiazki potwierdzony");
        }
        else { System.out.println("Nie ma ksiazki o podanym ID");}
    }

    public void detale(int idDetale){
        System.out.println(lib.get(idDetale).toString());
    }

    public int liczbaPozyczonychKsiazek(){

        int dostepnosc = 0;
        for (Book temp: lib.values()){
            if (temp.dostepnoscKsiazki() == false){dostepnosc = dostepnosc + 1;}
        }
        return dostepnosc;
    }

    public int getSize() {
        return lib.size();
    }
}
