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
		tekstgr = new Tekstgrensesnitt();
		sc = new Scanner(System.in);
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
			System.out.println("Vis filmer, søk på tittel (2)");
			System.out.println("Vis filmer, søk på produsent (3)");
			System.out.println("Skriv ut statistikk (4)");
			System.out.println("Lagre filmarkiv (5)");
			System.out.println("Avslutt (6)\n");
			System.out.print("Ditt valg: ");
			valg = sc.nextLine();
			System.out.println();

			if(valg.equals("1")) {
				Film film = tekstgr.lesFilm();
				fa.leggTilFilm(film);
			} else if(valg.equals("2")) {
				System.out.print("Oppgi delstreng i tittel: ");
				String tittel = sc.nextLine();
				System.out.println();
				tekstgr.skrivUtFilmDelstrengITittel(fa, tittel);
			} else if(valg.equals("3")) {
				System.out.print("Oppgi delstreng i produsent: ");
				String produsent = sc.nextLine();
				System.out.println();
				tekstgr.skrivUtFilmProdusent(fa, produsent);
			} else if(valg.equals("4")) {
				tekstgr.skrivUtStatistikk(fa);
			} else if(valg.equals("5")) {
				System.out.print("Oppgi filnavn: ");
				String filnavn = sc.nextLine();
				System.out.println();
				Fil.skrivTilFil(fa, filnavn);
			} else if(valg.equals("6")) {
				ferdig = true;
			}

		}
	}

}
