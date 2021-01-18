package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;

public class Tekstgrensesnitt {

	public Film lesFilm() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Filmnr: ");
		int filmnr = Integer.parseInt(sc.nextLine());
		System.out.print("Produsent: ");
		String produsent = sc.nextLine();
		System.out.print("Tittel: ");
		String tittel = sc.nextLine();
		System.out.print("�rstall: ");
		int aarstall = Integer.parseInt(sc.nextLine());
		System.out.print("Sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Filmselskap: ");
		String filmselskap = sc.nextLine();

		return new Film(filmnr, produsent, tittel, aarstall, sjanger, filmselskap);
	}

	public void visFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("�rstall: " + film.getAarstall());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Filmselskap: " + film.getFilmselskap());
	}

	public void skrivUtFilmDelstrengITittel(FilmarkivADT fa, String delstreng) {
		Film[] filmer = fa.soekTittel(delstreng);

		for(Film film : filmer) {
			visFilm(film);
		}
	}

	public void skrivUtFilmProdusent(FilmarkivADT fa, String delstreng) {
		Film[] filmer = fa.soekProdusent(delstreng);

		for(Film film : filmer) {
			visFilm(film);
		}
	}

	public void skrivUtStatistikk(FilmarkivADT fa) {
		System.out.println("Antall filmer totalt: " + fa.antall());

		for(Sjanger sjanger : Sjanger.values()) {
			System.out.format("Antall filmer i sjangeren %s: %d%n", sjanger, fa.antall(sjanger));
		}
	}

}
