package model.prevoznoSredstvo;
import enumeracija.KlasaAvionskogMesta;
import model.lokacije.Adresa;

public class Avion extends PrevoznoSredstvo {
	private KlasaAvionskogMesta klasa;

	
	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Avion [klasa=" + klasa + ", obrok=" + obrok + ", adresaPolaska=" + adresaPolaska + ", adresaPovratka="
				+ adresaPovratka + "]";
	}


	public Avion(boolean obrok, Adresa adresaPolaska, Adresa adresaPovratka, KlasaAvionskogMesta klasa) {
		super(obrok, adresaPolaska, adresaPovratka);
		this.klasa = klasa;
	}

	public KlasaAvionskogMesta getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaAvionskogMesta klasa) {
		this.klasa = klasa;
	}


	@Override
	public double zakupi() {
		double cena =0;
		if(this.obrok == true) {
			cena = 540+640;
		}else {
			cena = 640;
		}
		if (this.getKlasa().equals(KlasaAvionskogMesta.biznis)) {
			cena += 1000;
		}else {
			cena += 250;
		}
		return cena;
	}
	@Override
	public void otkazi() {
		// TODO Auto-generated method stub
		
	}
	
	


}
