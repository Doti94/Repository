package zadanieRekrutacyjne;

import java.util.List;

public class Engine {
	   
	   
	    
	    private List<Pracownicy> PracownicyList;

	    public Engine() {
	        setPracownicyList(Connector.getTableList());
	    }

	    public Pracownicy printPracownicyDetails(String pracownicyNazwisko) {
	        for(Pracownicy item : getPracownicyList()) {
	            if(item.getNazwisko().equals(pracownicyNazwisko)) {
	                return item;
	            }
	        }
	        return null;
	    }

	    public void addPracownicyToList(String[] addPracownicy) {
	        setPracownicyList(Connector.addPracownicyToTable(addPracownicy));
	    }

	    public void removePracownicyFromList(String pracownicyNazwisko) {
	        setPracownicyList(Connector.removePracownicyFromTable(pracownicyNazwisko));
	    }
	    
	    public List<Pracownicy> getPracownicyList() {
	        return PracownicyList;
	    }
	    
	    public void setPracownicyList(List<Pracownicy> pracownicyList) {
	        this.PracownicyList = pracownicyList;
	    }
	}



