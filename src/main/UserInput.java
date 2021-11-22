package main;

import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int mainMenu() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("1. Napraviti prikaz (view) koji će nam omogućiti da prikažemo proizvode i kategorije kojima pripadaju.");
        System.out.println("2. Za svaki region (CountryRegion) izračunati koliko godišnje zaradi. Prikazati tako da za svaki region, jedna ispod druge budu prikazane godine opadajuće.");
        System.out.println("3. Prilagoditi zadatak 2 tako da se zarada klasifikuje na sledeći način 0-99 slaba, 100-999 prosečna, 1000-9999 fina, preko 10000 odlična.");
        System.out.println("4. Napisati proceduru koja za prosleđenu prodavnicu nam vraća koliko je imala narudžbina od otvaranja, koliki je prosečan broj stvari kupljen po jednoj narudžbini i koliko je zaradila.");
        System.out.println("5. Pronaći zaposlenog (po teritorijama) koji najviše proizvoda proda.");
        System.out.println("6. Za svaku valutu izračunati koliko se puta koristila, sortirati prikaz opadajuće.");
        System.out.println("7. Kreirati view koji će nam opisati kupce po regionu. Koliko ih ima, koliko prosečno proizvoda kupuju, koliko prosečno troše.");
        System.out.println("8. Prikazati proizvode rastuće na osnovu toga koliko je iznosila njihova prodaja.");
        System.out.println("9. Napisati proceduru kojom za određeni model proizvoda(na osnovu imena) možemo da vidimo koji kupci su ga kupili, u kojoj državi.");
        System.out.println("10. Kreirati prikaz (view) na kome će se videti model (koji mu je id, naziv) i na kojim sve jezicima ima opis.");
        System.out.println("11. Svi proizvodi (id, ime, cena) koji imaju uputstvo na traženom jeziku.");
        System.out.println("12. Broj zaposlenih po prodavnicama koji se isplaćuju dva puta mesečno.");
        System.out.println("13. Analiza odseka : kolika je prosečna satnica po odseku, koliko je prosečno zaposlenih u braku, koji je procenat žena u odseku, prosečna starost zaposlenih, koliko u proseku su zaposleni.");
        System.out.println("0. Izlaz");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int departmentAnalysis() {
        System.out.println("1. Prosecna satnica po odseku.");
        System.out.println("2. Prosecno zaposlenih u braku po odseku.");
        System.out.println("3. Procenat zena po odseku.");
        System.out.println("4. Prosecna starost zaposlenih po odseku.");
        System.out.println("5. Prosecna duzina zaposlenja po odseku.");
        System.out.println("0. Nazad");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String input11() {
        System.out.println("Unesite jezik: ");
        return scanner.nextLine();
    }

    public static String input4() {
        System.out.println("Unesite ime prodavnice: ");
        return scanner.nextLine();
    }

    public static String input9() {
        System.out.println("Unesite ime proizvoda: ");
        return scanner.nextLine();
    }
}
