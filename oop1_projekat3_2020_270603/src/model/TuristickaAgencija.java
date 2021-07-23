package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



import enumeracija.KlasaAvionskogMesta;
import enumeracija.KlasaVoznogMesta;
import enumeracija.TipPansiona;
import model.aranzman.Aranzman;
import model.aranzman.Paket;
import model.korisnici.Agent;
import model.korisnici.Klijent;
import model.korisnici.Korisnik;
import model.lokacije.Adresa;
import model.lokacije.Drzava;
import model.lokacije.Mesto;
import model.prevoznoSredstvo.Avion;
import model.prevoznoSredstvo.PrevoznoSredstvo;
import model.prevoznoSredstvo.Voz;
import model.smestaji.Apartman;
import model.smestaji.Hotel;
import model.smestaji.Smestaj;

public class TuristickaAgencija {
	private static final Mesto Mesto = null;
	private String naziv;
	private List<Agent> agenti;
	private List<Klijent> klijenti;
	private List<Drzava> drzave;
	private List<Mesto> mesta;
	private List<Adresa> adrese;
	private List<Aranzman> aranzmani;
	private List<Avion> avioni;
	private List<Voz> vozovi;
	private List<Hotel> hoteli;
	private List<Apartman> apartmani;
	private List<Paket> paketi;
	
	public TuristickaAgencija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Aranzman> getAranzmani() {
		return aranzmani;
	}


	public void setAranzmani(List<Aranzman> aranzmani) {
		this.aranzmani = aranzmani;
	}





	public TuristickaAgencija(String naziv) {
		super();
		this.naziv = naziv;
		this.klijenti = new ArrayList<Klijent>();
		this.agenti = new ArrayList<Agent>();
		this.drzave = new ArrayList<Drzava>();
		this.mesta = new ArrayList<Mesto>();
		this.adrese = new ArrayList<Adresa>();
		this.hoteli = new ArrayList<Hotel>();
		this.apartmani = new ArrayList<Apartman>();
		this.aranzmani = new ArrayList<Aranzman>();
		this.avioni = new ArrayList<Avion>();
		this.vozovi = new ArrayList<Voz>();
		this.paketi = new ArrayList<Paket>();
	}
	
	@Override
	public String toString() {
		return "TuristickaAgencija [naziv=" + naziv + ", agenti=" + agenti + ", klijenti=" + klijenti + ", drzave="
				+ drzave + ", mesta=" + mesta + ", adrese=" + adrese + "]";
	}
	public List<Drzava> getDrzave() {
		return drzave;
	}


	public void setDrzave(List<Drzava> drzave) {
		this.drzave = drzave;
	}


	public List<Mesto> getMesta() {
		return mesta;
	}


	public void setMesta(List<Mesto> mesta) {
		this.mesta = mesta;
	}


	public List<Adresa> getAdrese() {
		return adrese;
	}


	public void setAdrese(List<Adresa> adrese) {
		this.adrese = adrese;
	}


	public List<Avion> getAvioni() {
		return avioni;
	}


	public void setAvioni(List<Avion> avioni) {
		this.avioni = avioni;
	}


	public List<Voz> getVozovi() {
		return vozovi;
	}


	public void setVozovi(List<Voz> vozovi) {
		this.vozovi = vozovi;
	}


	public List<Hotel> getHoteli() {
		return hoteli;
	}


	public void setHoteli(List<Hotel> hoteli) {
		this.hoteli = hoteli;
	}


	public List<Apartman> getApartmani() {
		return apartmani;
	}


	public void setApartmani(List<Apartman> apartmani) {
		this.apartmani = apartmani;
	}


	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Klijent> getKlijenti() {
		return klijenti;
	}
	public void setKlijenti(List<Klijent> klijenti) {
		this.klijenti = klijenti;
	}
	public List<Agent> getAgenti() {
		return agenti;
	}
	public void setAgenti(List<Agent> agenti) {
		this.agenti = agenti;
	}
	
	
	
	
	public Korisnik prijava(String korIme, String sifra) {
		for(Klijent k : this.klijenti) {
			if (k.getKorisnickoIme().equals(korIme) && k.getLozinka().equals(sifra)) {
				return k;
			}else {
			
			}
		
		}
		for (Agent a: this.agenti) {
			if(a.getKorisnickoIme().equals(korIme)&& a.getLozinka().equals(sifra)) {
				return a;
			}else {
				System.out.println("Nije pronadjen korisnik sa datim korisnickim imenom");
				app();
			}
		
		}
		return null;
	}
	public void app(){
		try {
			
			
			System.out.println("------------------------------------------------------");
			System.out.println("Dobrodosli u pocetni meni!");
			System.out.println("Izaberite jednu od ponudjenih opcija" +"\n"+ "1. Prijava" +"\n"+ "2.Izlaz");
			Scanner sc= new Scanner(System.in);
		
			int izabranaOpcija = sc.nextInt();
			if(izabranaOpcija == 1) {
				System.out.println("Unesite korisnicko ime: ");
				String kIme = sc.next();
				System.out.println("Unesite lozinku: ");
				String sifra = sc.next();
					
				Korisnik ulogovanKorisnik = this.prijava(kIme, sifra);
				if (ulogovanKorisnik != null) {
					if(ulogovanKorisnik instanceof Klijent) {
						
						meniKlijent(ulogovanKorisnik);
					}else if(ulogovanKorisnik instanceof Agent) {
						meniAgent(ulogovanKorisnik);
					
				}
			}else if(izabranaOpcija == 2) {
				System.exit(0);
			}else if (izabranaOpcija>2) {
				System.out.println("Unesite jednu od ponudjenih opcija" );
				app();
			}
			}
			
		}catch(InputMismatchException exception ) {
			System.out.println("Unesite jednu od ponudjenih opcija.");
			app();}
		}
		
	
	//meni za agenta
	public void meniAgent(Korisnik ulogovanKorisnik) {
		System.out.println("DOBRODOSLI NA SISTEM, " + ulogovanKorisnik.getIme() + " " + ulogovanKorisnik.getPrezime());
		System.out.println("1-Kreiranje aranzmana" + "\n"+ "2-Kreiranje paketa" +"\n" + "3-Brisanje paketa" + "\n" + "4-Odjava");
		try {
			Scanner sc = new Scanner(System.in);
			int izabranaOpcija = sc.nextInt();
			if(izabranaOpcija ==1) {
				kreiranjeAranzmana(ulogovanKorisnik);
			}else if(izabranaOpcija == 4) {
				app();
			}else if(izabranaOpcija == 2) {
				kreiranjePaketaAgent(ulogovanKorisnik);
			}else if(izabranaOpcija == 3) {
				brisanjePaketa(ulogovanKorisnik);
			}else if(izabranaOpcija == 4) {
				app();
			}else {
				System.out.println("Unesite jednu od ponudjenih opcija");
				meniAgent(ulogovanKorisnik);
			}
			
		}catch(InputMismatchException exception ) {
			System.out.println("Unesite jednu od ponudjenih opcija.");
			app();
			}
	}
	//meni za klijenta 
	public void meniKlijent(Korisnik k) {
		System.out.println("DOBRODOSLI NA SISTEM, " + k.getIme() + " " + k.getPrezime());
		System.out.println("1-Uplata novca" + "\n" + "2-Kreiranje paketa" + "\n" + "3-Zakupljivanje paketa" + "\n" + "4-Otkazivanje paketa" +"\n" + "5-Odjava");
		try {
			Scanner sc = new Scanner(System.in);
			int izabranaOpcija = sc.nextInt();
			if(izabranaOpcija == 1) {
				uplataNovca(k);
			}else if(izabranaOpcija ==5) {
				app();
			}else if(izabranaOpcija == 4) {
				for(Klijent klijent : this.klijenti) {
					if(klijent.getIme().equals(k.getIme()) && klijent.getPrezime().equals(k.getPrezime()) && klijent.getKorisnickoIme().equals(k.getKorisnickoIme()) && klijent.getLozinka().equals(k.getLozinka())) {
						otkazivanjePaketa(klijent);
					}
				}
			}else if(izabranaOpcija == 3) {
				for(Klijent klijent : this.klijenti) {
					if(klijent.getIme().equals(k.getIme()) && klijent.getPrezime().equals(k.getPrezime()) && klijent.getKorisnickoIme().equals(k.getKorisnickoIme()) && klijent.getLozinka().equals(k.getLozinka())) 
						zakupljivanjePaketa(klijent);
				}
			}else if(izabranaOpcija == 2) {
				for(Klijent klijent : this.klijenti) {
					if(klijent.getIme().equals(k.getIme()) && klijent.getPrezime().equals(k.getPrezime()) && klijent.getKorisnickoIme().equals(k.getKorisnickoIme()) && klijent.getLozinka().equals(k.getLozinka())) {
						kreiranjePaketaKlijent(klijent);
					}
				}
				
			}
			else {
				System.out.println("Morate uneti jednu od ponudjenih opcija.");
				meniKlijent(k);
			}
		}catch(InputMismatchException exception ) {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();}
	}
	
	public void kreiranjeAranzmana(Korisnik ulogovanKorisnik) {
		try {
			Boolean izabranoOSiguranje = Osiguranje();
			Boolean izaberiGrupnoPutovanje = Grupni();
			Drzava izabranaDrzava = izaberiDrzavu();
			Mesto izabranoMesto = izaberiMesto(izabranaDrzava);
			Smestaj izabraniSmestaj = izaberiSmestaj(izabranoMesto);
			PrevoznoSredstvo izabranoPrevoznoSredstvo = izaberiPrevoznoSredstvo(izabranoMesto);
			LocalDate datumPolaska = Datumpolaska();
			LocalDate datumPovratka = DatumPovratka();
			Aranzman a = new Aranzman();
			a.setOsiguranje(izabranoOSiguranje);
			a.setGrupni(izaberiGrupnoPutovanje);
			a.setSmestaj(izabraniSmestaj);
			a.setPrevoz(izabranoPrevoznoSredstvo);
			a.setDatumPolaska(datumPolaska);
			a.setDatumPovratka(datumPovratka);
			this.aranzmani.add(a);
			upisiAranzmane();
			meniAgent(ulogovanKorisnik);
			
		}catch(InputMismatchException exception ) {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
			}
	}
	
	public void kreiranjePaketaAgent(Korisnik ulogovanKorisnik) {
		int procenatPovrata = povratNovca();
		List<Aranzman> listaArazmana = listaAranzmana();
	
		
		Paket paket = new Paket();
		paket.setPovrat(procenatPovrata);
		paket.setAranzmani(listaArazmana);
		paket.setKorisnik(ulogovanKorisnik);
		paket.setKlijent(null);
		
		this.paketi.add(paket);
		upisiPakete();
		System.out.println(paket);
		meniAgent(ulogovanKorisnik);
	}
	
	public void brisanjePaketa(Korisnik ulogovanKorisnik) {
		try {
			int brojac = 0;
			System.out.println("Izaberite paket koji zelite da izbrisete.");
			for(Paket p : this.paketi) {
				brojac++;
				System.out.println(brojac + ". "+ p);
				
				}
	
	
		Scanner sc = new Scanner(System.in);
		int izborOpcija = sc.nextInt();
		paketi.remove(izborOpcija-1);
		System.out.println(paketi);
		upisiPakete();
		meniAgent(ulogovanKorisnik);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	public void otkazivanjePaketa(Klijent ulogovaniKlijent) {
		int brojac = 0;
		for(Paket p : this.paketi) {
			
			if(p.getKlijent().equals(ulogovaniKlijent)) {
				brojac++;
				System.out.println("Izaberite paket koji zelite da otkazete");
				Scanner sc = new Scanner(System.in);
				int izabraniPaketOpcija = sc.nextInt();
				Paket izabraniPaket = paketi.get(izabraniPaketOpcija-1);
				p.setKlijent(null);
				upisiPakete();
				meniKlijent(ulogovaniKlijent);
			}else {
				System.out.println("Niste zakupili ni jedan paket");
			}
		}
	}
	
	public void zakupljivanjePaketa(Klijent ulogovaniKlijent) {
		for(Paket p : this.paketi) {
			int brojac = 0;
			System.out.println("Izaberite paket koji zelite da zakupite.");
			if(p.getKlijent() == null) {
				brojac++;
				System.out.println(brojac + ". " + p);
				Scanner sc = new Scanner(System.in);
				int izabraniPketOpcija =  sc.nextInt();
				
				Paket izabraniPaket = paketi.get(izabraniPketOpcija -1 );
				if(ulogovaniKlijent.getNovcanik()>izabraniPaket.zakupi()) {
					p.setKlijent(ulogovaniKlijent);
					upisiPakete();	
					meniKlijent(ulogovaniKlijent);
				}else {
					System.out.println("Nemate dovoljno sredstava za zakup ovog paketa.");
					meniKlijent(ulogovaniKlijent);
				}
				
			}else if(p.getKlijent()!=null) {
				System.out.println("Nema dostupnih paketa");
				meniKlijent(ulogovaniKlijent);
			}
		}
	}
	
	public void kreiranjePaketaKlijent(Klijent ulogovaniKlijent) {
		int procenatPovrata = povratNovca();
		List<Aranzman> listaArazmana = listaAranzmana();
	
		
		Paket paket = new Paket();
		paket.setPovrat(procenatPovrata);
		paket.setAranzmani(listaArazmana);
		paket.setKorisnik(ulogovaniKlijent);
		paket.setKlijent(ulogovaniKlijent);
		
		this.paketi.add(paket);
		upisiPakete();
		meniKlijent(ulogovaniKlijent);
	}
	// funkcija za dodavanje novca na stanje klijenta.
	public int povratNovca() {
		System.out.println("Unesite procenat povrata novca");
		Scanner sc = new Scanner(System.in);
		int iznos = sc.nextInt();
		if(iznos<100 && iznos>0) {
			return iznos;
		}else {
			System.out.println("Unesite iznos u opsegu 0-100");
			povratNovca();
		}
		return iznos;
	}
	
	public List<Aranzman> listaAranzmana() {
		List<Aranzman> aranzmaniIzabrani = new ArrayList<Aranzman>();
		List<Aranzman> aranzmaniOpcije = this.aranzmani;
		int brojac = 0;
		int izbor = 1;
		try {
		while (izbor !=0 ) {
			for(Aranzman a : aranzmaniOpcije) {
				brojac++;
				System.out.println(brojac +". "+a);
			}
			System.out.println("Unesite redni broj aranzmana ili za prekid unesite '0'");
			Scanner sc = new Scanner(System.in);
			brojac = 0;
			izbor = sc.nextInt();
			if(izbor != 0) {
				aranzmaniIzabrani.add(aranzmaniOpcije.get(izbor-1));
				aranzmaniOpcije.remove(izbor-1);
			}
		}
		
		}catch(IndexOutOfBoundsException e){
			System.out.println("Unesite jednu od ponudjenih opcija.");
			app();
		}
		return aranzmaniIzabrani;
		
	}
	
	public void uplataNovca(Korisnik k) {
		System.out.println("Unesite iznos koji zelite da dodate na racun.");
		Scanner sc = new Scanner(System.in);
		double iznos = sc.nextInt();
		for(Klijent k1: this.klijenti) {
			double trenutnoStanje = k1.getNovcanik();
			if(iznos>0) {
				double uvecanoStanje = trenutnoStanje += iznos;
				k1.setNovcanik(uvecanoStanje);
				upisiKlijenta();
				System.out.println(k1.novcanik);
				meniKlijent(k);
			}else {
				System.out.println("Morate uneti pozitivan broj");
				meniKlijent(k);
			}
		}
	}
	//funkcija za ucitavanje klijenta iz csv fajla, poziva se jednom na pocetku
	public void ucitajKlijente() {
		try {
			File klijentFajl= new File("src/datoteke/klijent.csv");
			BufferedReader br = new BufferedReader(new FileReader(klijentFajl));
			String line = null;
			while((line = br.readLine())!= null) {
			
				String[] split = line.split(",");
				String ime = split[0];
			
				String prezime = split[1];
				String korisnickoIme = split[2];
				String lozinka = split[3];
				String uloga = split[4];
				Double novcanik = Double.parseDouble(split[5]);
				Klijent klijent = new Klijent(ime,prezime, korisnickoIme, lozinka, uloga, novcanik);
				this.klijenti.add(klijent);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ucitajVozove() {
		try {
			File vozFajl = new File("src/datoteke/voz.csv");
			BufferedReader br = new BufferedReader(new FileReader(vozFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split("/");
				Boolean obrok = Boolean.valueOf(split[0]);
				String adresaPolaska = split[1];
				String adresaDolaska = split[2];
				KlasaVoznogMesta klasa = KlasaVoznogMesta.valueOf(split[3]);
				//Ovde cu da dobijem adresu polaska
				String[] adresaPolaskaList = adresaPolaska.split(",");
				String ulica1 = adresaPolaskaList[0];
				String broj1 = adresaPolaskaList[1];
				String grad1 = adresaPolaskaList[2];
				
				Adresa adresaPolaskaObj = vratiAdresu(ulica1, broj1, grad1);
				//
				//Ovde cu da dobijem adresu dolaska
				String[] adresaDolaskaList = adresaDolaska.split(",");
				String ulica2 = adresaDolaskaList[0];
				String broj2 = adresaDolaskaList[1];
				String grad2 = adresaDolaskaList[2];
				Adresa adresaDolaskaObj = vratiAdresu(ulica2, broj2, grad2);
			
				//
				
				Voz v = new Voz(obrok, adresaPolaskaObj, adresaDolaskaObj, klasa);
				
				this.vozovi.add(v);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upisiPakete() {
		try {
			File paketFajl = new File("src/datoteke/paket.csv");
			String string = "";
			for(Paket p :this.paketi) {
				if(p.getKlijent() != null) {
					string += p.getPovrat() + "x"  + p.getKorisnik().getIme() + ","+ p.getKorisnik().getPrezime()+","+p.getKorisnik().getKorisnickoIme()+","+p.getKorisnik().getLozinka()+","+p.getKorisnik().getUloga() +"x" 
							+ p.getKlijent().getIme() + ","+ p.getKlijent().getPrezime()+","+p.getKlijent().getKorisnickoIme()+","+p.getKlijent().getLozinka()+","+p.getKlijent().getUloga()+"x"; 
				}else {
					string += p.getPovrat() + "x"  + p.getKorisnik().getIme() + ","+ p.getKorisnik().getPrezime()+","+p.getKorisnik().getKorisnickoIme()+","+p.getKorisnik().getLozinka()+","+p.getKorisnik().getUloga() +"x" 
							+ "null"+"x";
				}
				
				for(Aranzman a : p.getAranzmani()) {
					
					if(a.getPrevoz() instanceof Avion) {
						for(Avion avion : this.avioni) {
							if (a.getPrevoz().getAdresaPolaska().equals(avion.getAdresaPolaska()) && a.getPrevoz().getAdresaPovratka().equals(avion.getAdresaPovratka()) && a.getPrevoz().isObrok() == avion.isObrok()) {
								string+= a.isOsiguranje()+":"+a.isGrupni()+":" + a.getDatumPolaska().toString()+":"+a.getDatumPovratka().toString()+":"+"avion"+";"+avion.isObrok()+"/"+avion.getAdresaPolaska().getUlica()+","+avion.getAdresaPolaska().getBroj()+","+avion.getAdresaPolaska().getMesto().getGrad()+"/"+avion.getAdresaPovratka().getUlica()+","+avion.getAdresaPovratka().getBroj()+","+avion.getAdresaPovratka().getMesto().getGrad()+"/" + avion.getKlasa();
							}
						}
						
					}else {
						
						for(Voz voz : this.vozovi) {
							if (a.getPrevoz().getAdresaPolaska().equals(voz.getAdresaPolaska()) && a.getPrevoz().getAdresaPovratka().equals(voz.getAdresaPovratka()) && a.getPrevoz().isObrok() == voz.isObrok()) {
								string+= a.isOsiguranje()+":"+a.isGrupni()+":" + a.getDatumPolaska().toString()+":"+a.getDatumPovratka().toString()+":"+"voz"+";"+voz.isObrok()+"/"+voz.getAdresaPolaska().getUlica()+","+voz.getAdresaPolaska().getBroj()+","+voz.getAdresaPolaska().getMesto().getGrad()+"/"+voz.getAdresaPovratka().getUlica()+","+voz.getAdresaPovratka().getBroj()+","+voz.getAdresaPovratka().getMesto().getGrad()+"/" + voz.getKlasa();
						
							}
						}
					}
					if(a.getSmestaj() instanceof Hotel) {
						for(Hotel hotel : this.hoteli) {
							if(a.getSmestaj().getPovrsina() == hotel.getPovrsina()&& a.getSmestaj().getBrojKreveta() == hotel.getBrojKreveta()&&a.getSmestaj().getTip().equals(hotel.getTip())&&a.getSmestaj().getAdresa().getUlica().contentEquals(hotel.getAdresa().getUlica())&& a.getSmestaj().getAdresa().getBroj().equals(hotel.getAdresa().getBroj())&&a.getSmestaj().getAdresa().getMesto().getGrad().equals(hotel.getAdresa().getMesto().getGrad())) {
								string+= ":hotel;" + hotel.getPovrsina()+","+hotel.getBrojKreveta()+","+hotel.getTip()+","+hotel.getBrojZvezdica()+","+hotel.getAdresa().getUlica()+","+hotel.getAdresa().getBroj()+","+hotel.getAdresa().getMesto().getGrad() +"Y" ;
							}
							
						}
					}else
						for(Apartman apartman : this.apartmani) {
							if(a.getSmestaj().getPovrsina() == apartman.getPovrsina()&& a.getSmestaj().getBrojKreveta() == apartman.getBrojKreveta()&&a.getSmestaj().getTip().equals(apartman.getTip())&& a.getSmestaj().getAdresa().getUlica().equals(apartman.getAdresa().getUlica())&& a.getSmestaj().getAdresa().getBroj().equals(apartman.getAdresa().getBroj())&&a.getSmestaj().getAdresa().getMesto().getGrad().equals(apartman.getAdresa().getMesto().getGrad())) {
								string +=":apartman;" + apartman.getPovrsina()+","+apartman.getBrojKreveta()+","+apartman.getTip()+","+apartman.getAdresa().getUlica()+","+apartman.getAdresa().getBroj()+","+apartman.getAdresa().getMesto().getGrad() + "Y" ;
						}
					}
		
				}	
				 string += "\n";
				
			}
			BufferedWriter upisi = new BufferedWriter(new FileWriter(paketFajl));
			
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void upisiAranzmane() {
		try {
			File aranzmaniFajl = new File("src/datoteke/aranzmani.csv");
			String string = "";
			for(Aranzman a : this.aranzmani) {
				
				if(a.getPrevoz() instanceof Avion) {
					for(Avion avion : this.avioni) {
						if (a.getPrevoz().getAdresaPolaska().equals(avion.getAdresaPolaska()) && a.getPrevoz().getAdresaPovratka().equals(avion.getAdresaPovratka()) && a.getPrevoz().isObrok() == avion.isObrok()) {
							string+= a.isOsiguranje()+":"+a.isGrupni()+":" + a.getDatumPolaska().toString()+":"+a.getDatumPovratka().toString()+":"+"avion"+";"+avion.isObrok()+"/"+avion.getAdresaPolaska().getUlica()+","+avion.getAdresaPolaska().getBroj()+","+avion.getAdresaPolaska().getMesto().getGrad()+"/"+avion.getAdresaPovratka().getUlica()+","+avion.getAdresaPovratka().getBroj()+","+avion.getAdresaPovratka().getMesto().getGrad()+"/" + avion.getKlasa();
						}
					}
					
				}else {
					
					for(Voz voz : this.vozovi) {
						if (a.getPrevoz().getAdresaPolaska().equals(voz.getAdresaPolaska()) && a.getPrevoz().getAdresaPovratka().equals(voz.getAdresaPovratka()) && a.getPrevoz().isObrok() == voz.isObrok()) {
							string+= a.isOsiguranje()+":"+a.isGrupni()+":" + a.getDatumPolaska().toString()+":"+a.getDatumPovratka().toString()+":"+"voz"+";"+voz.isObrok()+"/"+voz.getAdresaPolaska().getUlica()+","+voz.getAdresaPolaska().getBroj()+","+voz.getAdresaPolaska().getMesto().getGrad()+"/"+voz.getAdresaPovratka().getUlica()+","+voz.getAdresaPovratka().getBroj()+","+voz.getAdresaPovratka().getMesto().getGrad()+"/" + voz.getKlasa();
					
						}
					}
				}
				if(a.getSmestaj() instanceof Hotel) {
					for(Hotel hotel : this.hoteli) {
						if(a.getSmestaj().getPovrsina() == hotel.getPovrsina()&& a.getSmestaj().getBrojKreveta() == hotel.getBrojKreveta()&&a.getSmestaj().getTip().equals(hotel.getTip())&&a.getSmestaj().getAdresa().getUlica().contentEquals(hotel.getAdresa().getUlica())&& a.getSmestaj().getAdresa().getBroj().equals(hotel.getAdresa().getBroj())&&a.getSmestaj().getAdresa().getMesto().getGrad().equals(hotel.getAdresa().getMesto().getGrad())) {
							string+= ":hotel;" + hotel.getPovrsina()+","+hotel.getBrojKreveta()+","+hotel.getTip()+","+hotel.getBrojZvezdica()+","+hotel.getAdresa().getUlica()+","+hotel.getAdresa().getBroj()+","+hotel.getAdresa().getMesto().getGrad() +"\n" ;
						}
						
					}
				}else
					for(Apartman apartman : this.apartmani) {
						if(a.getSmestaj().getPovrsina() == apartman.getPovrsina()&& a.getSmestaj().getBrojKreveta() == apartman.getBrojKreveta()&&a.getSmestaj().getTip().equals(apartman.getTip())&& a.getSmestaj().getAdresa().getUlica().equals(apartman.getAdresa().getUlica())&& a.getSmestaj().getAdresa().getBroj().equals(apartman.getAdresa().getBroj())&&a.getSmestaj().getAdresa().getMesto().getGrad().equals(apartman.getAdresa().getMesto().getGrad())) {
							string +=":apartman;" + apartman.getPovrsina()+","+apartman.getBrojKreveta()+","+apartman.getTip()+","+apartman.getAdresa().getUlica()+","+apartman.getAdresa().getBroj()+","+apartman.getAdresa().getMesto().getGrad() + "\n" ;
					}
				}
	
			}	
		
			BufferedWriter upisi = new BufferedWriter(new FileWriter(aranzmaniFajl));
			
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upisiAvione() {
		try {
			File avioniFajl = new File("src/datoteke/avion.csv");
			String string ="";
			
			for(Avion a : this.avioni) {
			
				string+= a.isObrok() +"/" + a.getAdresaPolaska().getUlica()+ ","+a.getAdresaPolaska().getBroj()+","+a.getAdresaPolaska().getMesto().getGrad()+"/"+a.getAdresaPovratka().getUlica()+ ","+a.getAdresaPovratka().getBroj()+","+a.getAdresaPovratka().getMesto().getGrad()+"/" + a.getKlasa()+"\n";
			
			}
			
			BufferedWriter upisi = new BufferedWriter(new FileWriter(avioniFajl));
			
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//PRETRAGA SACUVAJ VOZ
	public void upisiVozove() {
		try {
			File vozoviFajl = new File("src/datoteke/voz.csv");
			String string ="";
			
			for(Voz v : this.vozovi) {
			
				string+= v.isObrok() +"/" + v.getAdresaPolaska().getUlica()+ ","+v.getAdresaPolaska().getBroj()+","+v.getAdresaPolaska().getMesto().getGrad()+"/"+v.getAdresaPovratka().getUlica()+ ","+v.getAdresaPovratka().getBroj()+","+v.getAdresaPovratka().getMesto().getGrad()+"/" + v.getKlasa()+"\n";
			
			}
			
			BufferedWriter upisi = new BufferedWriter(new FileWriter(vozoviFajl));
			
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upisiHotele() {
		try {
			File hotelfajl = new File("src/datoteke/Hoteli.csv");
			String string = "";
			for(Hotel h:this.hoteli) {
				string += h.getPovrsina() + "," + h.getBrojKreveta() + ","+h.getTip() + "," + h.getBrojZvezdica() + "," + h.getAdresa().getUlica()+","+h.getAdresa().getBroj()+","+h.getAdresa().getMesto().getGrad()+"\n";
				
			}
			BufferedWriter upisi = new BufferedWriter(new FileWriter(hotelfajl));
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upisiApartmane(){
		try {
			File apartmanFajl = new File("src/datoteke/apartmani.csv");
			String string = "";
			for(Apartman a:this.apartmani) {
				string += a.getPovrsina() + "," + a.getBrojKreveta() + ","+a.getTip() + "," + "," + a.getAdresa().getUlica()+","+a.getAdresa().getBroj()+","+a.getAdresa().getMesto().getGrad()+"\n";
				
			}
			BufferedWriter upisi = new BufferedWriter(new FileWriter(apartmanFajl));
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upisiKlijenta() {
		try {
			File klijentFajl = new File("src/datoteke/klijent.csv");
			String string = "";
			for(Klijent k:this.klijenti) {
				string+= k.getIme() + ","+k.getPrezime()+","+k.getKorisnickoIme()+","+k.getLozinka()+","+k.getUloga()+","+k.getNovcanik()+"\n";
			
			}
			BufferedWriter upisi = new BufferedWriter(new FileWriter(klijentFajl));
			upisi.write(string);
			upisi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ucitajAvione() {
		try {
			File vozFajl = new File("src/datoteke/avion.csv");
			BufferedReader br = new BufferedReader(new FileReader(vozFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split("/");
				Boolean obrok = Boolean.valueOf(split[0]);
				String adresaPolaska = split[1];
				String adresaDolaska = split[2];
				KlasaAvionskogMesta klasa = KlasaAvionskogMesta.valueOf(split[3]);
				//Ovde cu da dobijem adresu polaska
				String[] adresaPolaskaList = adresaPolaska.split(",");
				String ulica1 = adresaPolaskaList[0];
				String broj1 = adresaPolaskaList[1];
				String grad1 = adresaPolaskaList[2];
				Adresa adresaPolaskaObj = vratiAdresu(ulica1, broj1, grad1);
				//
				//Ovde cu da dobijem adresu dolaska
				String[] adresaDolaskaList = adresaDolaska.split(",");
				String ulica2 = adresaDolaskaList[0];
				String broj2 = adresaDolaskaList[1];
				String grad2 = adresaDolaskaList[2];
				Adresa adresaDolaskaObj = vratiAdresu(ulica2, broj2, grad2);
				//
				
				Avion a = new Avion(obrok, adresaPolaskaObj, adresaDolaskaObj, klasa);
				
				this.avioni.add(a);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ucitajPekete() {
		try {
			File paketFajl = new File("src/datoteke/paket.csv");
			BufferedReader br = new BufferedReader(new FileReader(paketFajl));
			String line = null;
			while((line = br.readLine())!= null) {
			
				String[] split = line.split("x");
			
			
				int procenat = Integer.parseInt(split[0]);
				
			
				String[] korisnik = split[1].split(",");
				
				
				String ime = korisnik[0];
				String prezime = korisnik[1];
				String korisnickoIme = korisnik[2];
				String lozinka = korisnik[3];
				String uloga= korisnik[4];
				Korisnik vlasnikPaketa;
				if(uloga.equals("AGENT")) {
					vlasnikPaketa = new Agent(ime, prezime, korisnickoIme, lozinka, uloga);
				}else {
					vlasnikPaketa = new Klijent(ime, prezime, korisnickoIme, lozinka);
				}
				
				Klijent zakupacPaketa;
				if(split[2].equals("null")) {
					zakupacPaketa = null;
				}else {
					String[] klijent = split[2].split(",");
					String ime1 = klijent[0];
					
					String prezime1 = klijent[1];
					String korisnickoIme1 = klijent[2];
					String lozinka1 = klijent[3];
					String uloga1 = klijent[4];
					//Double novcanik = Double.parseDouble(split[5]);
					zakupacPaketa = new Klijent(ime1, prezime1, korisnickoIme1, lozinka1);
				}
				
				
				String[] aranzmani = split[3].split("Y");
				List<Aranzman> arazmaniList = new ArrayList<Aranzman>();
				int brojElemenata = 0;
				
				while(brojElemenata < aranzmani.length) {
					
					String[] aranmzman = aranzmani[brojElemenata].split(":");
					
					Boolean osiguranje = Boolean.valueOf(aranmzman[0]);
					Boolean grupni = Boolean.valueOf(aranmzman[1]);
					
					
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					
					LocalDate datumPolaska = LocalDate.parse(aranmzman[2], formatter);
					LocalDate datumPovratka = LocalDate.parse(aranmzman[3], formatter);
					
					//Da dobijem prevozno
					PrevoznoSredstvo prevozno;
					String[] prevoznoSplit = aranmzman[4].split(";");
					if(prevoznoSplit[0].equals("avion")) {
						
						//String prevtest = prevoznoSplit[1];
						Avion a = vratiAvion(prevoznoSplit[1]);
						prevozno = a;
					}else {
						Voz v = vratiVoz(prevoznoSplit[1]);
						prevozno = v;
					}
					//
					//Da dobijem smestaj
					Smestaj smestaj;
					String[] smestajSplit = aranmzman[5].split(";");
					if(smestajSplit[0].equals("hotel")) {
						Hotel h = vratiHotel(smestajSplit[1]);
						smestaj = h;
					}else {
						Apartman a = vratiApratman(smestajSplit[1]);
						smestaj = a;
					}
					
					Aranzman a = new Aranzman();
					a.setOsiguranje(osiguranje);
					a.setGrupni(grupni);
					a.setDatumPolaska(datumPolaska);
					a.setDatumPovratka(datumPovratka);
					a.setPrevoz(prevozno);
					a.setSmestaj(smestaj);
					
					arazmaniList.add(a);
					
					brojElemenata++;
				
				}
				Paket paket = new Paket();
				paket.setAranzmani(arazmaniList);
				paket.setKlijent(zakupacPaketa);
				paket.setKorisnik(vlasnikPaketa);
				paket.setPovrat(procenat);
				
				
				this.paketi.add(paket);
				
				System.out.println(paket);
		
			}
			br.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("OVDE");
				}
			
			}
		
		
	public void ucitajAranzmane() {
		try {
			File adresaFajl = new File("src/datoteke/aranzmani.csv");
			BufferedReader br = new BufferedReader(new FileReader(adresaFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(":");
				
				Boolean osiguranje = Boolean.valueOf(split[0]);
				Boolean grupni = Boolean.valueOf(split[1]);
				
				
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				LocalDate datumPolaska = LocalDate.parse(split[2], formatter);
				LocalDate datumPovratka = LocalDate.parse(split[3], formatter);
				
				//Da dobijem prevozno
				PrevoznoSredstvo prevozno;
				String[] prevoznoSplit = split[4].split(";");
				if(prevoznoSplit[0].equals("avion")) {
					
					Avion a = vratiAvion(prevoznoSplit[1]);
					prevozno = a;
				}else {
					Voz v = vratiVoz(prevoznoSplit[1]);
					prevozno = v;
				}
				//
				//Da dobijem smestaj
				Smestaj smestaj;
				String[] smestajSplit = split[5].split(";");
				if(smestajSplit[0].equals("hotel")) {
					Hotel h = vratiHotel(smestajSplit[1]);
					smestaj = h;
				}else {
					Apartman a = vratiApratman(smestajSplit[1]);
					smestaj = a;
				}
				
				
				Aranzman aranzman = new Aranzman(osiguranje, grupni, datumPolaska, datumPovratka, prevozno, smestaj);
				//
				this.aranzmani.add(aranzman);
				
				
 				
			}
		}catch(Exception e) {
				e.printStackTrace();
				}
	}
	//vraca hotel
	
	public Hotel vratiHotel(String line) {
	
		String[] split = line.split(",");
		String kvadratura = split[0];
		String brojkreveta = split[1];
		TipPansiona tip = TipPansiona.valueOf(split[2]);
		String brojZvezdica = split[3];
		String adresaUlica = split[4];
		String adresaBroj = split[5];
		String grad = split[6];
		
		Hotel h = new Hotel();
		h.setPovrsina(Double.parseDouble(kvadratura));
		h.setBrojKreveta(Integer.parseInt(brojkreveta));
		h.setBrojZvezdica(Integer.valueOf(brojZvezdica));
		h.setTip(tip);
		
		for(Mesto mesto : this.mesta) {
			for(Adresa a : mesto.getAdresa()) {

				if(mesto.grad.equals(grad) && a.getUlica().equals(adresaUlica) && a.getBroj().equals(adresaBroj)) {
					
					h.setAdresa(a);
				}
			}
		}
		
		return h;
	
	}
	//vraca apartman 
	public Apartman vratiApratman(String line) {
	
		String[] split = line.split(",");
		String kvadratura = split[0];
		String brojkreveta = split[1];
		TipPansiona tip = TipPansiona.valueOf(split[2]);
		String adresaUlica = split[3];
		String adresaBroj = split[4];
		String grad = split[5];
		
		Apartman a1 = new Apartman();
		a1.setPovrsina(Double.parseDouble(kvadratura));
		a1.setBrojKreveta(Integer.parseInt(brojkreveta));
		a1.setTip(tip);
		
		for(Mesto mesto : this.mesta) {
			for(Adresa a : mesto.getAdresa()) {

				if(mesto.grad.equals(grad) && a.getUlica().equals(adresaUlica) && a.getBroj().equals(adresaBroj)) {
					
					a1.setAdresa(a);
				}
			}
		}
		return a1;
	}

	//vraca avion
	public Avion vratiAvion(String line) {
		
		String[] split = line.split("/");
		Boolean obrok = Boolean.valueOf(split[0]);
		String adresaPolaska = split[1];
		String adresaDolaska = split[2];
		KlasaAvionskogMesta klasa = KlasaAvionskogMesta.valueOf(split[3]);
		//Ovde cu da dobijem adresu polaska
		String[] adresaPolaskaList = adresaPolaska.split(",");
		String ulica1 = adresaPolaskaList[0];
		String broj1 = adresaPolaskaList[1];
		String grad1 = adresaPolaskaList[2];
		Adresa adresaPolaskaObj = vratiAdresu(ulica1, broj1, grad1);
		//
		//Ovde cu da dobijem adresu dolaska
		String[] adresaDolaskaList = adresaDolaska.split(",");
		String ulica2 = adresaDolaskaList[0];
		String broj2 = adresaDolaskaList[1];
		String grad2 = adresaDolaskaList[2];
		Adresa adresaDolaskaObj = vratiAdresu(ulica2, broj2, grad2);
		//
		
		Avion a = new Avion(obrok, adresaPolaskaObj, adresaDolaskaObj, klasa);
		
		return a;
	}
	//vraca voz
	public Voz vratiVoz(String line) {
		String[] split = line.split("/");
		Boolean obrok = Boolean.valueOf(split[0]);
		String adresaPolaska = split[1];
		String adresaDolaska = split[2];
		KlasaVoznogMesta klasa = KlasaVoznogMesta.valueOf(split[3]);
		//Ovde cu da dobijem adresu polaska
		String[] adresaPolaskaList = adresaPolaska.split(",");
		String ulica1 = adresaPolaskaList[0];
		String broj1 = adresaPolaskaList[1];
		String grad1 = adresaPolaskaList[2];
		Adresa adresaPolaskaObj = vratiAdresu(ulica1, broj1, grad1);
		//
		//Ovde cu da dobijem adresu dolaska
		String[] adresaDolaskaList = adresaDolaska.split(",");
		String ulica2 = adresaDolaskaList[0];
		String broj2 = adresaDolaskaList[1];
		String grad2 = adresaDolaskaList[2];
		Adresa adresaDolaskaObj = vratiAdresu(ulica2, broj2, grad2);
		//
		
		Voz v = new Voz(obrok, adresaPolaskaObj, adresaDolaskaObj, klasa);
		
		return v;
	}
	//vraca adresu 
	public Adresa vratiAdresu(String ulica, String broj, String grad) {
		Adresa adresa = new Adresa();
		for(Mesto mesto : this.mesta) {
			for(Adresa a : mesto.getAdresa()) {	
				if(a.getMesto().getGrad().equals(grad) && a.getUlica().equals(ulica) && a.getBroj().equals(broj)) {
					
					adresa = a;
					
					
				}
			}
		}
		return adresa;
		
	}
	
	public void ucitajDrzave() {
		try {
			File drzaveFajl = new File("src/datoteke/drzava.csv");
			BufferedReader br = new BufferedReader(new FileReader(drzaveFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String ime = line;
				Drzava drzava = new Drzava(ime);
				this.drzave.add(drzava);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void ucitajMesta() {
		try {
			File mestaFajl = new File("src/datoteke/mesto.csv");
			BufferedReader br = new BufferedReader(new FileReader(mestaFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(",");
				String grad = split[0];
				String drzava = split[1];
				Drzava d = nadjiDrzavu(drzava);
				Mesto mesto = new Mesto(grad, d);
				this.mesta.add(mesto);
				d.getMesta().add(mesto);			
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ucitajAdrese() {
		try {
			File adresaFajl = new File("src/datoteke/adresa.csv");
			BufferedReader br = new BufferedReader(new FileReader(adresaFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(",");
				String ulica = split[0];
				String broj = split[1];
				String mesto = split[2];
				Mesto m =nadjiMesto(mesto);
				Adresa a = new Adresa(ulica,broj,m);
				m.getAdresa().add(a);
				this.adrese.add(a);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void ucitajApartmane() {
		try {
			File adresaFajl = new File("src/datoteke/apartmani.csv");
			BufferedReader br = new BufferedReader(new FileReader(adresaFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(",");
				String kvadratura = split[0];
				String brojkreveta = split[1];
				TipPansiona tip = TipPansiona.valueOf(split[2]);
				String adresaUlica = split[3];
				String adresaBroj = split[4];
				String grad = split[5];
				
				Apartman a1 = new Apartman();
				a1.setPovrsina(Double.parseDouble(kvadratura));
				a1.setBrojKreveta(Integer.parseInt(brojkreveta));
				a1.setTip(tip);
				
				for(Mesto mesto : this.mesta) {
					for(Adresa a : mesto.getAdresa()) {

						if(mesto.grad.equals(grad) && a.getUlica().equals(adresaUlica) && a.getBroj().equals(adresaBroj)) {
							
							a1.setAdresa(a);
						}
					}
				}
				
				this.apartmani.add(a1);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void ucitajHotele() {
		try {
			File adresaFajl = new File("src/datoteke/Hoteli.csv");
			BufferedReader br = new BufferedReader(new FileReader(adresaFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(",");
				String kvadratura = split[0];
				String brojkreveta = split[1];
				TipPansiona tip = TipPansiona.valueOf(split[2]);
				String brojZvezdica = split[3];
				String adresaUlica = split[4];
				String adresaBroj = split[5];
				String grad = split[6];
				
				Hotel h = new Hotel();
				h.setPovrsina(Double.parseDouble(kvadratura));
				h.setBrojKreveta(Integer.parseInt(brojkreveta));
				h.setBrojZvezdica(Integer.valueOf(brojZvezdica));
				h.setTip(tip);
				
				for(Mesto mesto : this.mesta) {
					for(Adresa a : mesto.getAdresa()) {

						if(mesto.grad.equals(grad) && a.getUlica().equals(adresaUlica) && a.getBroj().equals(adresaBroj)) {
							
							h.setAdresa(a);
						}
					}
				}
			
				
				this.hoteli.add(h);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ucitajAgente() {
		try {
			File agentFajl = new File("src/datoteke/agent.csv");
			BufferedReader br = new BufferedReader(new FileReader(agentFajl));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] split = line.split(",");
				String ime = split[0];
				String prezime = split[1];
				String korisnickoIme = split[2];
				String lozinka = split[3];
				String uloga= split[4];
				
				Agent a = new Agent(ime, prezime,korisnickoIme,lozinka,uloga);
				this.agenti.add(a);
			
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Drzava nadjiDrzavu(String imeDrzave) {
		for(Drzava d : this.drzave) {
			if(d.getDrzava().equals(imeDrzave)) {
				return d;
			}
		}
		return null;
	}
	
	public Mesto nadjiMesto(String imeMesta) {
		for(Mesto m : this.mesta) {
			if(m.getGrad().equals(imeMesta)) {
				return m;
			}
		}
		return null;
	}
	
	public void ispisiLokacije() {
		for(Drzava d : this.drzave) {
			for(Mesto m : d.getMesta()) {
				for(Adresa a : m.getAdresa()) {
					System.out.println("Drzava :" + d.getDrzava() + " grad: " + m.getGrad() + " adresa: " + a.getUlica() + " " + a.getBroj());
				}
			}
		}
	}
	
	public Drzava izaberiDrzavu  () {
		System.out.println("Izaberite drzavu koju zelite da dodate u aranzman.");
		int brojac = 0;
		
		for(Drzava adresa: drzave) {
			brojac ++;
			System.out.println(brojac+". " + adresa.getDrzava());
		}
		System.out.println("Upisite redni broj drzave: ");
		Scanner sc = new Scanner(System.in);
		int izabranaDrzavaInput  = sc.nextInt();
		Drzava izabranaDrzava = new Drzava();
		try {
		for(Drzava drzava: this.drzave) {
				izabranaDrzava = drzave.get(izabranaDrzavaInput-1);
				
		}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Uneta opcija nije podrzana.");
			app();
		}
		return izabranaDrzava;
	}
	
	public LocalDate Datumpolaska() {
		System.out.println("Upisite vreme polasku u formatu gggg-MM-dd");
		Scanner sc= new Scanner(System.in);
		String odabraniDatum = sc.next();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(odabraniDatum,formater);
		System.out.println("Izabrano vreme polaska: " + localDate);
		return localDate;
		
	}
		//Izabrano vreme dolaska
	public LocalDate DatumPovratka() {
		System.out.println("Upisite vreme dolaska u formatu gggg-MM-dd");
		Scanner sc= new Scanner(System.in);
		String odabraniDatum1 = sc.next();
		DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate1 = LocalDate.parse(odabraniDatum1,formater1);
		System.out.println("Izabrano vreme dolaska: " + localDate1);
		return localDate1;
	}

	public boolean Osiguranje() {
		boolean osiguranje= false;
		System.out.println("Da li zelite osiguranje u sklopu aranzmana? " + "\n" + "1. Da" +"\n" + "2. Ne"+ "\n"+ "Unesite redni broj opcije.");
		Scanner sc = new Scanner(System.in);
		int izborOsiguranjaInput = sc.nextInt();
		try {
			if(izborOsiguranjaInput ==1 ) {
				osiguranje = true;
			}
			else if(izborOsiguranjaInput ==2) {
				osiguranje  = false;
			}else {
				System.out.println("Morate uneti jednu od ponudjenih opcija");
				app();
			}
			}catch(InputMismatchException exception ) {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			}
		return osiguranje;
	}
	
	public boolean Grupni() {
		boolean grupni = true;
		System.out.println("Da li zelite grupno putovanje u sklopu aranzmana? " + "\n" + "1. Da" +"\n" + "2. Ne"+ "\n"+ "Unesite redni broj opcije.");
		Scanner sc = new Scanner(System.in);
		int izborGrupnogPutovanjaInput = sc.nextInt();
		try {
			if(izborGrupnogPutovanjaInput ==1 ) {
				grupni = true;
			}
			else if(izborGrupnogPutovanjaInput == 2) {
				grupni  = false;
			}else {
				System.out.println("Morate uneti jednu od ponudjenih opcija");
				app();
			}
			}catch(InputMismatchException exception ) {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
			}
		return grupni;
	}
	
	public Mesto izaberiMesto(Drzava izabranaDrzava) {
		int brojac1 = 0;
		System.out.println("Unesite redni broj grada.");
		for(Mesto m: izabranaDrzava.getMesta()) {
			brojac1 ++;
			System.out.println(brojac1 + ". "+ m.getGrad());
		}
			Scanner sc = new Scanner(System.in);
			int izabraniGradInput = sc.nextInt();
			Mesto izabraniGrad = new Mesto();
			try {
			for(Mesto mesto: izabranaDrzava.getMesta() ) {
				
					izabraniGrad = izabranaDrzava.getMesta().get(izabraniGradInput-1);
				
			}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Uneta opcija nije podrzana");
			app();
		}
		return izabraniGrad;
	}
	
	public Smestaj izaberiSmestaj(Mesto mesto) {
		
		System.out.println("Da zelite " + "\n" + "1.Hotel" + "\n" + "2.Apartman");
		Scanner sc = new Scanner(System.in);
		int izbor = sc.nextInt();
		if(izbor==1) {
			
			System.out.println("Da li zelite postojeci hotel?");
			System.out.println("Izaberite opciju ili za dodavanje novog hotela unesite - '0'");
			List<Hotel> hoteliUGradu = vratiListuHotelaPoMestu(mesto);
			int brojac = 0;
			for(Hotel h : hoteliUGradu) {
				brojac++;
				System.out.println(brojac + ". Hotel " + brojac + 
						"\n" + "Broj kreveta: " + h.getBrojKreveta() +
						"\n" + "Povrsina: " + h.getPovrsina() + 
						"\n" + "Broj zvezdica: " + h.getBrojZvezdica()+
						"\n" + "Adresa: " + h.getAdresa().getUlica() + " " + h.getAdresa().getBroj() + " " + h.getAdresa().getMesto().getGrad() + 
						"\n" + "Tip smestaja: " + h.getTip() + 
						"\n" + "_______________________________________");
					
			}
			
				
			
			int izborHotelaOpcija = sc.nextInt();
			if(izborHotelaOpcija>0) {
				
				//izborHotelaOpcija-1 - zato sto u listi indexi krecu od 0; 
				return hoteliUGradu.get(izborHotelaOpcija - 1);
				
			
			}else {
				return dodavanjeNovogHotela(mesto);
			}
		}	
			else if(izbor ==2) {
				try {
				System.out.println("Da li zelite postojeci apartman?");
				System.out.println("Izaberite opciju ili za dodavanje novog apartmana unesite - '0'");
				
				List<Apartman> apartmaniUGradu = vratiListuApartmanaPoMestu(mesto);
				int brojac = 0;
				for(Apartman a: apartmaniUGradu) {
					
					brojac ++;
					System.out.println(brojac + ". Apartman" + brojac +
							"\n" + "Broj kreveta: " + a.getBrojKreveta() +
							"\n" + "Povrsina: " + a.getPovrsina() + 
							"\n" + "Adresa: " + a.getAdresa().getUlica() + " " + a.getAdresa().getBroj() + " " + a.getAdresa().getMesto().getGrad() + 
							"\n" + "Tip smestaja: " + a.getTip() + 
							"\n" + "_______________________________________");
				}
				int izborApartmanaOpcija = sc.nextInt();
				if(izborApartmanaOpcija>0) {
					
					//izborHotelaOpcija-1 - zato sto u listi indexi krecu od 0; 
					return apartmaniUGradu.get(izborApartmanaOpcija - 1);
					
				
				}else {
					return dodavanjeNovogApartmana(mesto);
				}
			}catch(NullPointerException e) {
				dodavanjeNovogApartmana(mesto);
			}catch (IndexOutOfBoundsException e) {
				System.out.println("Morate uneti jedn od ponudjenih opcija.");
			}
		}
		
	return null;
	}
	
	public PrevoznoSredstvo izaberiPrevoznoSredstvo(Mesto mesto) {
		try {
		System.out.println("Da li zelite"+ "\n" + "1. Avion" + "\n" + "2.Voz");
		Scanner sc = new Scanner(System.in);
		int izbor = sc.nextInt();
		if(izbor == 1) {
			System.out.println("Da li zelite postojeci let?" + "\n" + "Izaberite postojecu opciju ili unesite - '0'");
			List<Avion> aerodromiUGradu = vratiListuAvionaPoMestu(mesto);
			int brojac = 0;
			for(Avion a : aerodromiUGradu) {
				brojac++;
				System.out.println(brojac + "Avion" + brojac+
						"\n" + "Obrok: " + a.isObrok() +
						"\n" + "Adresa polaska: " + a.getAdresaPolaska() +
						"\n" + "Adresa dolaska " + a.getAdresaPovratka()+
						"\n" + "Klasa: "+ a.getKlasa());
			}
			int izborAvionaOpcija = sc.nextInt();
			if(izborAvionaOpcija>0) {
				return aerodromiUGradu.get(izborAvionaOpcija -1);
			}else {
				dodavanjeNovogAviona(mesto);
			}
		}
		else if(izbor == 2) {
			System.out.println("Da li zelite postojeci voz?" + "\n" + "Izaberite postojecu opciju ili unesite - '0");
			List<Voz> vozoviUGradu = vratiListuVozovaPoMestu(mesto);
			int brojac = 0;
			for(Voz v : vozoviUGradu) {
				brojac++;
				System.out.println(brojac + "Voz" + brojac+
						"\n" + "Obrok: " + v.isObrok() +
						"\n" + "Adresa polaska: " + v.getAdresaPolaska() + 
						"\n" + "Adresa dolaska " + v.getAdresaPovratka() + 
						"\n" + "Klasa: "+ v.getKlasa());
			}
			int izborVozaOpcija = sc.nextInt();
			if(izborVozaOpcija>0) {
				return vozoviUGradu.get(izborVozaOpcija -1);
			}else {
				dodavanjeNovogVoza(mesto);
			}
		}
		return null;
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
		}
		return null; 
}
	
	public List<Hotel> vratiListuHotelaPoMestu(Mesto m){
		List<Hotel> hoteli = new ArrayList<Hotel>();
		int brojac = 0;
		for(Hotel s : this.hoteli) {
			if(s.getAdresa().getMesto() == m) {
				hoteli.add(s);
				
			}
		}
		return hoteli;
		
	}
	
	public List<Apartman> vratiListuApartmanaPoMestu(Mesto m){
		try {
		List<Apartman> apartmani = new ArrayList<Apartman>();
		int brojac = 0;
		for(Apartman a : this.apartmani) {
			if(a.getAdresa().getMesto().equals(m)) {
				apartmani.add(a);
				
			}
		}
		}catch(NullPointerException e) {
			System.out.println("Nema apartmana u izabranom gradu");
		}
		return apartmani;
		
	}
	
	public List<Avion> vratiListuAvionaPoMestu(Mesto m){
		List<Avion> avioni = new ArrayList<Avion>();
		int brojac = 0;
		for(Avion a : this.avioni) {
			if(a.getAdresaPolaska().getMesto().equals(m)){
				avioni.add(a);
			}
		}
		return avioni;
	}
	
	public List<Voz> vratiListuVozovaPoMestu(Mesto m){
		List<Voz> vozovi = new ArrayList<Voz>();
		int brojac = 0;
		for(Voz v : this.vozovi) {
			if(v.getAdresaPovratka().getMesto().equals(m)){
				vozovi.add(v);
			}
		}
		return vozovi;
	}
	
	public Smestaj dodavanjeNovogHotela(Mesto mesto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite kvadraturu sobe.");
		Double kvadratura = sc.nextDouble();
		System.out.println("Unesite broj kreveta.");
		int brojKreveta = sc.nextInt();
		System.out.println("Izabertite tip pansiona.");
		System.out.print("1.nocenje, polupansion, punPansion, allInclusive");
		int izborTipaOpcija = sc.nextInt();
		TipPansiona tip = null;
		if(izborTipaOpcija ==1) {
			tip = TipPansiona.nocenje;
		}else if(izborTipaOpcija ==2) {
			tip = TipPansiona.polupansion;
		}else if(izborTipaOpcija ==3) {
			tip = TipPansiona.punPansion;
		}else if(izborTipaOpcija == 4) {
			tip = TipPansiona.allInclusive;
		}else {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
		}
		System.out.println("Izaberite broj zvezdica.");
		int brojZvezdica = 0;
		int brojZvezdicaOpcija = sc.nextInt();
		if(brojZvezdicaOpcija>0 && brojZvezdicaOpcija<6) {
			brojZvezdica = brojZvezdicaOpcija;
		}else {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
		}
		System.out.println(mesto.getGrad()+ "DOSTA CRTICA");
		System.out.println("Izaberite jednu od ponudjenih opcija za adresu");
		int brojac =0;
		for(Adresa a:adrese) {
			if(a.getMesto().getGrad().equals(mesto.getGrad())) {
				brojac ++;
				System.out.println(brojac + ". "+ a.getUlica()+a.getBroj());
			}
			
			
		}
		int izbor = sc.nextInt();
		Adresa izabranaAdresa = this.adrese.stream().filter(A->A.getMesto().getGrad()==mesto.getGrad()).collect(Collectors.toList()).get(izbor -1);
		System.out.println(izabranaAdresa);
		Hotel h = new Hotel();
		h.setPovrsina(kvadratura);
		h.setBrojKreveta(brojKreveta);
		h.setTip(tip);
		h.setBrojZvezdica(brojZvezdica);
		h.setAdresa(izabranaAdresa);
		this.hoteli.add(h);
		upisiHotele();
		
		return h;
	}
	
	public Smestaj dodavanjeNovogApartmana(Mesto mesto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite kvadraturu sobe.");
		Double kvadratura = sc.nextDouble();
		System.out.println("Unesite broj kreveta.");
		int brojKreveta = sc.nextInt();
		System.out.println("Izabertite tip pansiona.");
		System.out.print("1.nocenje, polupansion, punPansion, allInclusive");
		int izborTipaOpcija = sc.nextInt();
		TipPansiona tip = null;
		if(izborTipaOpcija ==1) {
			tip = TipPansiona.nocenje;
		}else if(izborTipaOpcija ==2) {
			tip = TipPansiona.polupansion;
		}else if(izborTipaOpcija ==3) {
			tip = TipPansiona.punPansion;
		}else if(izborTipaOpcija == 4) {
			tip = TipPansiona.allInclusive;
		}else {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
		}
				System.out.println("Izaberite jednu od ponudjenih opcija za adresu");
		int brojac =0;
		for(Adresa a:adrese) {
			if(a.getMesto().getGrad().equals(mesto.getGrad())) {
				brojac ++;
				System.out.println(brojac + ". "+ a.getUlica()+a.getBroj());
				

		
			}
		}
		int izbor = sc.nextInt();
		Adresa izabranaAdresa = this.adrese.stream().filter(A->A.getMesto().getGrad()==mesto.getGrad()).collect(Collectors.toList()).get(izbor -1);
		System.out.println(izabranaAdresa);
		Apartman a1 = new Apartman();
		a1.setPovrsina(kvadratura);
		a1.setBrojKreveta(brojKreveta);
		a1.setTip(tip);
		a1.setAdresa(izabranaAdresa);
		this.apartmani.add(a1);
		upisiApartmane();
		return a1;
	
	}
	
	public PrevoznoSredstvo dodavanjeNovogAviona(Mesto mesto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Da li zelite obrok u sklopu leta?");
		boolean izborObroka = false;
		String izborObrokaOpcija = sc.next();
		if(izborObrokaOpcija.equalsIgnoreCase("da")) {
			izborObroka = true;
		}else if(izborObrokaOpcija.equalsIgnoreCase("ne")){
			izborObroka = false;
		}else {
			System.out.println("Morate izabrati jednu od ponudjenih opcija");
			app();
		
		}
		System.out.println("Izabertite klasu leta.");
		System.out.print("1. biznis" + "\n"+ "2. ekonomska");
		int izborTipaOpcija = sc.nextInt();
		KlasaAvionskogMesta klasa = null;
		if(izborTipaOpcija ==1) {
			klasa = KlasaAvionskogMesta.biznis; 
		}else if(izborTipaOpcija ==2) {
			klasa = KlasaAvionskogMesta.ekonomska;
		}else {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
		}
		System.out.println("Izaberite polaznu adresu.");
		int brojac =0;
		for(Adresa a:adrese) {
			
				brojac ++;
				System.out.println(brojac + ". "+ a.getUlica()+a.getBroj());
				
			
		}
		int izbor = sc.nextInt();
		Adresa adresaPolaska = this.adrese.get(izbor-1);
		System.out.println("Izaberite adresu dolaska.");
		int brojac1 =0;
		for(Adresa a:adrese) {
			if(a.getMesto().getGrad().equals(mesto.getGrad())) {
				brojac1 ++;
				System.out.println(brojac1
						+ ". "+ a.getUlica()+a.getBroj());
			}
		}
		int izbor1 = sc.nextInt();
		Adresa adresaDolazna = this.adrese.stream().filter(A->A.getMesto().getGrad()==mesto.getGrad()).collect(Collectors.toList()).get(izbor1 -1);
		Avion a = new Avion();
		a.setAdresaPolaska(adresaPolaska);
		a.setAdresaPovratka(adresaDolazna);
		a.setKlasa(klasa);
		a.setObrok(izborObroka);
		this.avioni.add(a);
		upisiAvione();
		return a;
	}
	
	public PrevoznoSredstvo dodavanjeNovogVoza(Mesto mesto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Da li zelite obrok u sklopu puta?");
		boolean izborObroka = false;
		String izborObrokaOpcija = sc.next();
		if(izborObrokaOpcija.equalsIgnoreCase("da")) {
			izborObroka = true;
		}else if(izborObrokaOpcija.equalsIgnoreCase("ne")){
			izborObroka = false;
		}else {
			System.out.println("Morate izabrati jednu od ponudjenih opcija");
			app();
		
		}
		System.out.println("Izabertite klasu voza.");
		System.out.print("1. Prvi razred" + "\n"+ "2. Drugi razred" + "\n" + "3. Spavaca kola");
		int izborTipaOpcija = sc.nextInt();
		KlasaVoznogMesta klasa = null;
		if(izborTipaOpcija ==1) {
			klasa = KlasaVoznogMesta.prviRazred; 
		}else if(izborTipaOpcija ==2) {
			klasa = KlasaVoznogMesta.drugiRazred;
			
			}else if(izborTipaOpcija ==3) {
				klasa = KlasaVoznogMesta.spavacaKola;
		}else {
			System.out.println("Morate uneti jednu od ponudjenih opcija.");
			app();
		}
		System.out.println("Izaberite polaznu adresu.");
		int brojac =0;
		for(Adresa a:adrese) {
			
				brojac ++;
				System.out.println(brojac + ". "+ a.getUlica()+a.getBroj());
				
			
		}
		int izbor = sc.nextInt();
		Adresa adresaPolaska = this.adrese.get(izbor-1);
		System.out.println("Izaberite adresu dolaska.");
		int brojac1 =0;
		for(Adresa a:adrese) {
			if(a.getMesto().getGrad().equals(mesto.getGrad())) {
				brojac1 ++;
				System.out.println(brojac1+ ". "+ a.getUlica()+a.getBroj());
			}
		}
		int izbor1 = sc.nextInt();
		Adresa adresaDolazna = this.adrese.stream().filter(A->A.getMesto().getGrad()==mesto.getGrad()).collect(Collectors.toList()).get(izbor1 -1);
		Voz v = new Voz();
		v.setAdresaPolaska(adresaPolaska);
		v.setAdresaPovratka(adresaDolazna);
		v.setKlasa(klasa);
		v.setObrok(izborObroka);
		this.vozovi.add(v);
		upisiVozove();
		return v;
	}
}
		

