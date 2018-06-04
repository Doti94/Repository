package zadanieRekrutacyjne;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Pracownicy {
	
	public  Integer id_pracownika;
	public String imie;
	public String nazwisko;
	public String stanowisko;
	public Integer pensja;
	public Date data_zatrudnienia;
	
	public Pracownicy(){
		
	}
	
	public Pracownicy (String imie, String nazwiko, String stanowisko, Integer pensja, Date data_zatrudnienia) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stanowisko = stanowisko;
		this.pensja = pensja;
		this.data_zatrudnienia = data_zatrudnienia;	
	}

	public Integer getId_pracownika() {
		return id_pracownika;
	}
	
	public void setId_pracownika(int int1) {
		
	}
		

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Integer getPensja() {
		return pensja;
	}

	public void setPensja(Integer pensja) {
		this.pensja = pensja;
	}

	public Date getData_zatrudnienia() {
		return data_zatrudnienia;
	}

	public void setData_zatrudnienia(Date date) {
		this.data_zatrudnienia = data_zatrudnienia;
	}
	

}