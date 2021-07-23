package model.smestaji;

import enumeracija.TipPansiona;
import model.lokacije.Adresa;

public class Apartman extends Smestaj {

	public Apartman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartman(double povrsina, int brojKreveta, TipPansiona tip, Adresa adresa) {
		super(povrsina, brojKreveta, tip, adresa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Apartman [getPovrsina()=" + getPovrsina() + ", getBrojKreveta()=" + getBrojKreveta() + ", getTip()="
				+ getTip() + ", getAdresa()=" + getAdresa().toString();
	}

	@Override
	public double zakupi() { 
			double cena =0;
			if(this.getTip().equals(TipPansiona.allInclusive)) {
				cena = 3600;
			}else if(this.getTip().equals(TipPansiona.nocenje)) {
				cena = 1200; 
			}else if(this.getTip().equals(TipPansiona.nocenjeSaDoruckom)) {
				cena= 1700;
			}else if(this.getTip().equals(TipPansiona.polupansion)) {
				cena = 2100;
			}else if(this.getTip().equals(TipPansiona.punPansion)) {
				cena = 2800;
			}
			return cena;
		
	
	}

	@Override
	public void otkazi() {
		// TODO Auto-generated method stub
		System.out.println("Smestaj je otkazan.");
	}
	
	
}
