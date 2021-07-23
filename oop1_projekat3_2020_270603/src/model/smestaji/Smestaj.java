package model.smestaji;

import aplikacija.Zakupljivo;
import enumeracija.TipPansiona;
import model.lokacije.Adresa;

public abstract class Smestaj implements Zakupljivo{
	private double povrsina;
	private int brojKreveta;
	private TipPansiona tip;
	private Adresa adresa;
	public Smestaj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Smestaj(double povrsina, int brojKreveta, TipPansiona tip, Adresa adresa) {
		super();
		this.povrsina = povrsina;
		this.brojKreveta = brojKreveta;
		this.tip = tip;
		this.adresa = adresa;
	}
	public double getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	public TipPansiona getTip() {
		return tip;
	}
	public void setTip(TipPansiona tip) {
		this.tip = tip;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	@Override
	public String toString() {
		return "Smestaj [povrsina=" + povrsina + ", brojKreveta=" + brojKreveta + ", tip=" + tip + ", adresa=" + adresa;
	}
	
	
}
