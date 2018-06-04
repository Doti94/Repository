package zadanieRekrutacyjne;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import zadanieRekrutacyjne.Pracownicy;

public class UserInterface<action> {
    private BufferedReader reader;
    private BufferedWriter writer;
    private Engine action = new Engine();

    public UserInterface() {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reader = new BufferedReader(new InputStreamReader(System.in));
        start();
    }

    private void printVersion() {
        println("┌───────────────────────────┐");
        println("│        Pracownicy         │");
        println("└───────────────────────────┘");
    }
    
    private void showMenu() {
        println("┌───────────────────────────────┐");
        println("│ MENU (wybierz opcję):         │");
        println("├───────────────────────────────┤");
        println("│ 1) Pokaż Dane Pracowników     │");       
        println("│ 2) Dodaj Pracownika           │");       
        println("│ 3) Usuń Pracownika            │");       
        println("│ 4) Wyświetl Listę Pracowników │");       
        println("│ M) Pokaż Menu                 │");       
        println("│ Q) Zakończ Program            │");       
        println("└───────────────────────────────┘");
    }
    
    
    private void start() {
        printVersion();
        showMenu();
        print(">");
        while(selectOption(read())) {
            print(">");
        }
    }
    
    private boolean selectOption(String userIn) {
        switch (userIn.toLowerCase()) {
        case "1":
            showPracownicyDetails();
            return true;
        case "2":
            addPracownicy();
            return true;
        case "3":
            removePracownicy();
            return true;
        case "4":
            showPracownicyList();
            return true;
        case "m":
            showMenu();
            return true;
        case "q":
            println("═══════════════════");
            println("ZAKOŃCZONO PROGRAM!");
            return false;
        default:
            println("Nieprawidłowy wybór. Wybierz jeszcze raz!");
            return true;
        }
    }
    
   
		
	

	

	private void showPracownicyDetails() {
        print("Podaj Nazwisko Pracownika: ");
        Pracownicy pracownicy = action.printPracownicyDetails(read());
        if (pracownicy != null) {
            println("───────────────────────────────");
            println("SZCZEGÓŁY:");
            println("───────────────────────────────");
            printDetails(pracownicy);
            println("───────────────────────────────");
        } else {
            println("Na liście nie ma takiego pracownika! Spróbuj jeszcze raz.");
            showMenu();
        }
    }
    
    private <action> void showPracownicyList() {
        int i = 1;
        for (Pracownicy item : action.getPracownicyList()) {
            print(String.valueOf(i) + ") ");
            printPracownicyNazwisko(item);
            i++;
        }
    }
    
    private void addPracownicy() {
        String[] addPracownicy = new String[4];
        print("Podaj imię pracownika: ");
        addPracownicy[0] = read();
        print("Podaj nazwisko pracownika: ");
        addPracownicy[1] = read();
        print("Podaj zarobki pracownika: ");
        addPracownicy[2] = read();
        print("Podaj datę zatrudnienia: ");
        addPracownicy[3] = read();
        action.addPracownicyToList(addPracownicy);
    }
    
    private void removePracownicy() {
        print("Podaj nazwisko pracownika, którego chcesz usunąć: ");
        action.removePracownicyFromList(read());
    }
    
    private void printDetails(Pracownicy pracownicy) {
        String[] colName = new String[] {
                "Id                : ", 
                "imię              : ", 
                "nazwisko          : ", 
                "Pensja            : ", 
                "Data zatrudnienia : "};
        
        println(colName[0] + pracownicy.getId_pracownika());
        println(colName[1] + pracownicy.getImie());
        println(colName[2] + pracownicy.getNazwisko());
        println(colName[3] + pracownicy.getPensja());
        println(colName[4] + pracownicy.getData_zatrudnienia());
    }

    private void printPracownicyNazwisko(Pracownicy pracownicy) {
        println(pracownicy.getImie() + " - '" + pracownicy.getNazwisko() + "'");
    }
    
    private void print(String text) {
        try {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void println(String text) {
        print(text + "\r\n");
    }

    private String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

