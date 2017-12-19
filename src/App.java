import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean running = true;
        Scanner input = new Scanner(System.in);

        Library library = new Library();

        while (running) {
            System.out.println("Wybierz numer: " +
                    "\n0: Wylacz" +
                    "\n1: Dodaj ksiazke do bilblioteki" +
                    "\n2: Wypozycz ksiazke" +
                    "\n3: Pokaz wszystkie ksiazki w bibliotece" +
                    "\n4: Usun ksiazke z bilblioteki" +
                    "\n5: Wyszukaj ksiazke po tytule" +
                    "\n6: Wyszukaj ksiazke po ID" +
                    "\n7: Wyszukaj ksiazke po autorze" +
                    "\n8: Wyszukaj ksiazke po roku wydania" +
                    "\n9: Oddaj ksiazke" +
                    "\n10: Detale ksiazki" +
                    "\n\tLiczba ksiazek: " + library.getSize() +
                    "\n\tLiczba pozyczonych ksiazek: " + library.liczbaPozyczonychKsiazek());
            int answer = input.nextInt();

            switch (answer) {
                case 0: // Wylacz
                    running = false;
                    break;
                case 1: //Dodaj ksiazke

                    System.out.println("Podaj tytul ksiazki: ");
                    String nowyTytul = input.next();

                    System.out.println("Podaj autora ksiazki: ");
                    String nowyAutor = input.next();

                    System.out.println("Podaj rok publikacji: ");
                    int nowyRok = input.nextInt();

                    library.addBook(new Book(nowyTytul, nowyAutor, nowyRok));
                    break;
                case 2: //Wypozycz ksiazke

                    System.out.println("Podaj ID ksiazki: ");
                    int borrow = input.nextInt();
                    library.availabilityOfABook(borrow);
                    break;
                case 3: //Pokaz wszystkie ksiazki
                    //
                    library.displayLibrary();

                    break;
                case 4: //Usun ksiazke
                    System.out.println("Podaj ID ksiazki do usuniecia");
                    int usuniecieID = input.nextInt();
                    library.usunKsiazke(usuniecieID);
                    break;
                case 5: // Wyszukaj po tytule

                    System.out.println("Podaj tytul: ");
                    String szukajTytul = input.next();
                    library.searchTitle(szukajTytul);
                    break;
                case 6: //Wyszukaj po ID

                    System.out.println("Podaj numer ID: ");
                    int numer = input.nextInt();
                    library.searchTitle(numer);
                    break;
                case 7: // Wyszukaj po autorze

                    System.out.println("Podaj autora ksiazki: ");
                    String autor = input.next();
                    library.searchTitleAuthor(autor);
                    break;
                case 8: //Wyszukaj po roku wydania

                    System.out.println("Podaj rok wydania: ");
                    int rok = input.nextInt();
                    library.searchTitleYear(rok);
                    break;
                case 9: // Oddaj ksiazke

                    System.out.println("Podaj ID ksiazki");
                    int oddanie = input.nextInt();
                    library.oddawanieKsiazki(oddanie);
                    break;
                case 10:    // Detale ksiazki
                    System.out.println("Podaj ID ksiazki: ");
                    int detale = input.nextInt();
                    library.detale(detale);
                    break;
            }
        }
    }

}
