package aplikacija;


import java.util.Scanner;


import model.TuristickaAgencija;
import model.korisnici.Agent;
import model.korisnici.Klijent;
import model.korisnici.Korisnik;
import model.lokacije.Adresa;
import model.lokacije.Drzava;
import model.lokacije.Mesto;

public class Aplikacija {
	
	
	public static void main(String[] args) {
		TuristickaAgencija t1 = new TuristickaAgencija("Itaka");
		
		t1.ucitajKlijente();
		t1.ucitajDrzave();
		t1.ucitajMesta();
		t1.ucitajAdrese();
		t1.ucitajAgente();
		t1.ucitajApartmane();
		t1.ucitajVozove();
		t1.ucitajAvione();
		
		
		
		
		//Moraju biti ucitane adrese i mesta pre ove funkcije
		t1.ucitajHotele();
		
		t1.ucitajAranzmane();
		t1.ucitajPekete();

		t1.app();
		
		
		
		}
	
	

}
