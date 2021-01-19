package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {
	
	public static void main(String[] args) {
		FilmarkivADT fa = new Filmarkiv(10);
		Meny meny = new Meny(fa);
		meny.start();
	}

}
