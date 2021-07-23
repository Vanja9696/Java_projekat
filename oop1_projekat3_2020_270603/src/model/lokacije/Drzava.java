package model.lokacije;

import java.util.ArrayList;
import java.util.List;

public class Drzava {
	public String drzava;
	public List<Mesto> mesta;
	public Drzava(String drzava) {
		super();
		this.drzava = drzava;
		this.mesta = new ArrayList<Mesto>();
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	

	public Drzava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drzava(List<Mesto> mesta) {
		super();
		this.mesta = mesta;
	}

	public List<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(List<Mesto> mesta) {
		this.mesta = mesta;
	}}
