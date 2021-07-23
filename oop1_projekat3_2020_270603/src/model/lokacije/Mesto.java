package model.lokacije;

import java.util.ArrayList;
import java.util.List;

public class Mesto {
	public String grad;
	public Drzava drzava;
	public List<Adresa> adresa;

	public Mesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	




	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}


	public List<Adresa> getAdresa() {
		return adresa;
	}


	public void setAdresa(List<Adresa> adresa) {
		this.adresa = adresa;
	}




	public Mesto(String grad, Drzava drzava) {
		super();
		this.grad = grad;
		this.drzava = drzava;
		this.adresa = new ArrayList<Adresa>();
	}




	public Drzava getDrzava() {
		return drzava;
	}




	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}


	
	
}
