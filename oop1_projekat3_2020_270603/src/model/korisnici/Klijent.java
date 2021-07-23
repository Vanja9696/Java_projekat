package model.korisnici;

public class Klijent extends Korisnik {
	public double novcanik;

	public double getNovcanik() {
		return novcanik;
	}

	public void setNovcanik(double novcanik) {
		this.novcanik = novcanik;
	}

	public Klijent(String ime, String prezime, String korisnickoIme, String lozinka, String uloga, double novcanik) {
		super(ime, prezime, korisnickoIme, lozinka, uloga);
		this.novcanik = novcanik;
	}

	public Klijent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Klijent(String ime, String prezime, String korisnickoIme, String lozinka) {
		super(ime, prezime, korisnickoIme, lozinka);
		// TODO Auto-generated constructor stub
	}
	
}
