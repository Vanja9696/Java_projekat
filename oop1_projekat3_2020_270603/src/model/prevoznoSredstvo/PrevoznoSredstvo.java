package model.prevoznoSredstvo;

import aplikacija.Zakupljivo;
import model.lokacije.Adresa;

public abstract class PrevoznoSredstvo implements Zakupljivo {
	protected boolean obrok;
	protected Adresa adresaPolaska;
	protected Adresa adresaPovratka;
	public boolean isObrok() {
		return obrok;
	}
	public void setObrok(boolean obrok) {
		this.obrok = obrok;
	}
	public Adresa getAdresaPolaska() {
		return adresaPolaska;
	}
	public void setAdresaPolaska(Adresa adresaPolaska) {
		this.adresaPolaska = adresaPolaska;
	}
	public Adresa getAdresaPovratka() {
		return adresaPovratka;
	}
	public void setAdresaPovratka(Adresa adresaPovratka) {
		this.adresaPovratka = adresaPovratka;
	}
	public PrevoznoSredstvo(boolean obrok, Adresa adresaPolaska, Adresa adresaPovratka) {
		super();
		this.obrok = obrok;
		this.adresaPolaska = adresaPolaska;
		this.adresaPovratka = adresaPovratka;
	}
	public PrevoznoSredstvo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
