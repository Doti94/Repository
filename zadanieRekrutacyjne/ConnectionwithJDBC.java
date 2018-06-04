package zadanieRekrutacyjne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionwithJDBC implements Connector {
	

    private Connection conn;

	private String URL="jdbc:mysql://localhost/baza_danych_pracownicy";
	private String USER = "root";
	private String PASSWORD = "dorota13";
	private String TABLE = "Pracownicy";
	
	 private PreparedStatement stm;
	    private ResultSet res;
	    
	    private void createConn() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public List<Pracownicy> getTableList() {
	        createConn();
	        List<Pracownicy> pracownicyList = new ArrayList<Pracownicy>();
	        try {
	            stm = conn.prepareStatement("SELECT * FROM " + TABLE);
	            res = stm.executeQuery();
	            while (res.next()) {
	                Pracownicy pracownicy = new Pracownicy();
	                for (int i = 1; i <= res.getMetaData().getColumnCount(); i++) {
	                    switch (i) {
	                    case 1:
	                        pracownicy.setId_pracownika(res.getInt(i));
	                        break;
	                    case 2:
	                        pracownicy.setImie(res.getString(i));
	                        break;
	                    case 3:
	                        pracownicy.setNazwisko(res.getString(i));
	                        break;
	                    case 4:
	                        pracownicy.setPensja(res.getInt(i));
	                        break;
	                    case 5:
	                        pracownicy.setData_zatrudnienia(res.getDate(i));
	                        break;
	                    }
	                }
	                pracownicyList.add(pracownicy);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        createConn();
	        return pracownicyList;
	    }
	    public List<Pracownicy> addPracownicyToTable(String[] addPracownicy){
	        createConn();
	        try {
	            conn.createStatement().execute("INSERT INTO " + TABLE + 
	                    " (imie, nazwisko, stnowisko, pensja, data_zatrudnienia)");
	                    
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        createConn();
	        return (getTableList());
	    }
	    
	    public List<Pracownicy> removeBookFromTable(String pracownicyNazwisko){
	        createConn();
	        try {
	            conn.createStatement().execute("DELETE FROM " + TABLE + " WHERE nazwisko='" + pracownicyNazwisko + "';");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        createConn();
	        return (getTableList());
	    }
	        
	        private void closeConn() {
	            try {
	                stm.close();
	                res.close();
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
