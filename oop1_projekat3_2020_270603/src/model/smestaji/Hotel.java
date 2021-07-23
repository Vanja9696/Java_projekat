package model.smestaji;

import enumeracija.TipPansiona;
import model.lokacije.Adresa;

public class Hotel extends Smestaj {
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(double povrsina, int brojKreveta, TipPansiona tip, Adresa adresa) {
		super(povrsina, brojKreveta, tip, adresa);
		// TODO Auto-generated constructor stub
	}

	public Hotel(int brojZvezdica) {
		super();
		this.brojZvezdica = brojZvezdica;
	}

	public Hotel(Double kvadratura, int brojKreveta, TipPansiona tip, int brojZvezdica2, Adresa izabranaAdresa) {
		// TODO Auto-generated constructor stub
		super();
		this.brojZvezdica = brojZvezdica2;
	}

	public int getBrojZvezdica() {
		return brojZvezdica;
	}

	public void setBrojZvezdica(int brojZvezdica) {
		this.brojZvezdica = brojZvezdica;
	}

	protected int brojZvezdica;

	@Override
	public double zakupi() {
		double cena = 123*this.brojZvezdica;
		if(this.getTip().equals(TipPansiona.allInclusive)) {
			cena += 3600;
		}else if(this.getTip().equals(TipPansiona.nocenje)) {
			cena += 1200; 
		}else if(this.getTip().equals(TipPansiona.nocenjeSaDoruckom)) {
			cena+= 1700;
		}else if(this.getTip().equals(TipPansiona.polupansion)) {
			cena += 2100;
		}else if(this.getTip().equals(TipPansiona.punPansion)) {
			cena += 2800;
		}
		return cena;
	}

	@Override
	public void otkazi() {
		// TODO Auto-generated method stub
		
	}
}
