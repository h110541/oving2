package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;

public class Tekstgrensesnitt {

	private Scanner sc;

	public Tekstgrensesnitt(Scanner sc) {
		this.sc = sc;
	}

	public Film lesFilm() {
		System.out.print("Filmnr: ");
		int filmnr = Integer.parseInt(sc.nextLine());
		System.out.print("Produsent: ");
		String produsent = sc.nextLine();
		System.out.print("Tittel: ");
		String tittel = sc.nextLine();
		System.out.print("Årstall: ");
		int aarstall = Integer.parseInt(sc.nextLine());
		System.out.print("Sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Filmselskap: ");
		String filmselskap = sc.nextLine();
		System.out.println();

		return new Film(filmnr, produsent, tittel, aarstall, sjanger, filmselskap);
	}

	public void visOverskrift() {
		System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s%n%n", "Filmnr", "Produsent", "Tittel", "Årstall", "Sjanger", "Filmselskap");
	}

	public void visFilm(Film film) {
		System.out.format("%-10d %-20s %-20s %-20d %-20s %-20s%n", film.getFilmnr(), film.getProdusent(), film.getTittel(),
				film.getAarstall(), film.getSjanger(), film.getFilmselskap());
	}

	public void skrivUtFilmDelstrengITittel(FilmarkivADT fa, String delstreng) {
		Film[] filmer = fa.soekTittel(delstreng);
		visOverskrift();

		for(Film film : filmer) {
			visFilm(film);
		}

		System.out.println();
	}

	public void skrivUtFilmProdusent(FilmarkivADT fa, String delstreng) {
		Film[] filmer = fa.soekProdusent(delstreng);
		visOverskrift();

		for(Film film : filmer) {
			visFilm(film);
		}

		System.out.println();
	}

	public void skrivUtStatistikk(FilmarkivADT fa) {
		System.out.println("Antall filmer totalt: " + fa.antall());

		for(Sjanger sjanger : Sjanger.values()) {
			System.out.format("Antall filmer i sjangeren %s: %d%n", sjanger, fa.antall(sjanger));
		}

		System.out.println();
	}

}
