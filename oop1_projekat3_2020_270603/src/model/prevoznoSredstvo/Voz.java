package model.prevoznoSredstvo;

import enumeracija.KlasaVoznogMesta;
import model.lokacije.Adresa;

public class Voz extends PrevoznoSredstvo {
	
	protected KlasaVoznogMesta klasa;

	public Voz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voz(boolean obrok, Adresa adresaPolaska, Adresa adresaPovratka, KlasaVoznogMesta klasa) {
		super(obrok, adresaPolaska, adresaPovratka);
		this.klasa = klasa;
	}

	public KlasaVoznogMesta getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaVoznogMesta klasa) {
		this.klasa = klasa;
	}

	@Override
	public String toString() {
		return "Voz [klasa=" + klasa + ", obrok=" + obrok + ", adresaPolaska=" + adresaPolaska + ", adresaPovratka="
				+ adresaPovratka + "]";
	}

	@Override
	public double zakupi() {
		double cena =0;
		if(this.obrok == true) {
			cena = 540+640;
		}else {
			cena = 640;
		}
		if(this.getKlasa().equals(KlasaVoznogMesta.prviRazred)) {
			cena+=210;
		}else {
			cena += 1000;
		}
		return cena;
	}

	@Override
	public void otkazi() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
