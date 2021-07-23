package model.aranzman;

import java.util.List;

import aplikacija.Zakupljivo;
import model.korisnici.Agent;
import model.korisnici.Klijent;
import model.korisnici.Korisnik;

public class Paket implements Zakupljivo {
	protected int povrat;
	protected List<Aranzman> aranzmani;
	protected Korisnik korisnik;
	protected Klijent klijent;
	public Paket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paket(int povrat, List<Aranzman> aranzmani, Korisnik korisnik, Klijent klijent) {
		super();
		this.povrat = povrat;
		this.aranzmani = aranzmani;
		this.korisnik = korisnik;
		this.klijent = klijent;
	}
	public int getPovrat() {
		return povrat;
	}
	public void setPovrat(int povrat) {
		this.povrat = povrat;
	}
	public List<Aranzman> getAranzmani() {
		return aranzmani;
	}
	public void setAranzmani(List<Aranzman> aranzmani) {
		this.aranzmani = aranzmani;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aranzmani == null) ? 0 : aranzmani.hashCode());
		result = prime * result + ((klijent == null) ? 0 : klijent.hashCode());
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + povrat;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paket other = (Paket) obj;
		if (aranzmani == null) {
			if (other.aranzmani != null)
				return false;
		} else if (!aranzmani.equals(other.aranzmani))
			return false;
		if (klijent == null) {
			if (other.klijent != null)
				return false;
		} else if (!klijent.equals(other.klijent))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (povrat != other.povrat)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Paket [povrat=" + povrat + ", aranzmani=" + aranzmani + ", korisnik=" + korisnik + ", klijent="
				+ klijent + "]";
	}
	@Override
	public double zakupi() {
		Double cena = 0D;
		for (Aranzman a : this.aranzmani) {
			cena += a.getPrevoz().zakupi();
			cena += a.getSmestaj().zakupi();
		}
		
		return cena;
	}
	@Override
	public void otkazi() {
		// TODO Auto-generated method stub
		
	}

}
