package no.hvl.dat102.klient;

import no.hvl.dat102.Fil;
import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;

public class Meny {

	private FilmarkivADT fa;
	private Tekstgrensesnitt tekstgr;
	private Scanner sc;

	public Meny(FilmarkivADT fa) {
		this.fa = fa;
		sc = new Scanner(System.in);
		tekstgr = new Tekstgrensesnitt(sc);
	}

	public void start() {
		System.out.print("Nytt arkiv (1), eller eksisterende (2): ");
		String valg = sc.nextLine();
		System.out.println();

		if(valg.equals("2")) {
			System.out.print("Oppgi filnavn: ");
			String filnavn = sc.nextLine();
			fa = Fil.lesFraFil(filnavn);
			System.out.println();
		}

		hovedmeny();
	}

	private void hovedmeny() {
		String valg;
		boolean ferdig = false;

		while(!ferdig) {
			System.out.println("Legg til film (1)");
			System.out.println("Slett film (2)");
			System.out.println("Vis filmer, søk på tittel (3)");
			System.out.println("Vis filmer, søk på produsent (4)");
			System.out.println("Skriv ut statistikk (5)");
			System.out.println("Lagre filmarkiv (6)");
			System.out.println("Avslutt (7)\n");
			System.out.print("Ditt valg: ");
			valg = sc.nextLine();
			System.out.println();

			if(valg.equals("1")) {
				Film film = tekstgr.lesFilm();
				fa.leggTilFilm(film);
			} else if(valg.equals("2")) {
				System.out.print("Oppgi filmnr: ");
				int filmnr = Integer.parseInt(sc.nextLine());
				if(fa.slettFilm(filmnr)) {
					System.out.println("\nFilmen ble slettet\n");
				} else {
					System.out.println("\nFant ikke filmen i arkivet\n");
				}
			} else if(valg.equals("3")) {
				System.out.print("Oppgi delstreng i tittel: ");
				String tittel = sc.nextLine();
				System.out.println();
				tekstgr.skrivUtFilmDelstrengITittel(fa, tittel);
			} else if(valg.equals("4")) {
				System.out.print("Oppgi delstreng i produsent: ");
				String produsent = sc.nextLine();
				System.out.println();
				tekstgr.skrivUtFilmProdusent(fa, produsent);
			} else if(valg.equals("5")) {
				tekstgr.skrivUtStatistikk(fa);
			} else if(valg.equals("6")) {
				System.out.print("Oppgi filnavn: ");
				String filnavn = sc.nextLine();
				System.out.println();
				Fil.skrivTilFil(fa, filnavn);
			} else if(valg.equals("7")) {
				ferdig = true;
			}

		}
	}

}
