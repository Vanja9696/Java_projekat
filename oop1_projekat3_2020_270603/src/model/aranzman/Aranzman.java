package model.aranzman;

import java.time.LocalDate;
import java.time.LocalDateTime;

import enumeracija.KlasaAvionskogMesta;
import enumeracija.KlasaVoznogMesta;
import enumeracija.TipPansiona;
import model.prevoznoSredstvo.PrevoznoSredstvo;
import model.smestaji.Smestaj;

public class Aranzman {
	protected boolean osiguranje;
	protected boolean grupni;
	protected LocalDate datumPolaska;
	protected LocalDate datumPovratka;
	protected PrevoznoSredstvo prevoz;
	protected Smestaj smestaj;
	
	public Aranzman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aranzman(boolean osiguranje, boolean grupni, LocalDate datumPolaska, LocalDate datumPovratka,
			PrevoznoSredstvo prevoz, Smestaj smestaj) {
		super();
		this.osiguranje = osiguranje;
		this.grupni = grupni;
		this.datumPolaska = datumPolaska;
		this.datumPovratka = datumPovratka;
		this.prevoz = prevoz;
		this.smestaj = smestaj;
	}

	public boolean isOsiguranje() {
		return osiguranje;
	}

	public void setOsiguranje(boolean osiguranje) {
		this.osiguranje = osiguranje;
	}

	public boolean isGrupni() {
		return grupni;
	}

	public void setGrupni(boolean grupni) {
		this.grupni = grupni;
	}

	public LocalDate getDatumPolaska() {
		return datumPolaska;
	}

	public void setDatumPolaska(LocalDate datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public LocalDate getDatumPovratka() {
		return datumPovratka;
	}

	public void setDatumPovratka(LocalDate datumPovratka) {
		this.datumPovratka = datumPovratka;
	}

	public PrevoznoSredstvo getPrevoz() {
		return prevoz;
	}

	public void setPrevoz(PrevoznoSredstvo prevoz) {
		this.prevoz = prevoz;
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}

	@Override
	public String toString() {
		return "Aranzman [osiguranje=" + osiguranje + ", grupni=" + grupni + ", datumPolaska=" + datumPolaska
				+ ", datumPovratka=" + datumPovratka + ", prevoz=" + prevoz + ", smestaj=" + smestaj + "]";
	}
	
	
	

}
