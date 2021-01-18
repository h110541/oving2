package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fil {

	final static String SKILLE = "#";

	public static void skrivTilFil(FilmarkivADT fa, String filnavn) {

		Film[] filmer = fa.hentFilmTabell();
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(filnavn);
			pw.println(filmer.length);

			for(int i = 0; i < filmer.length; i++) {
				String filmLinje =
						filmer[i].getFilmnr() + SKILLE +
						filmer[i].getProdusent() + SKILLE +
						filmer[i].getTittel() + SKILLE +
						filmer[i].getAarstall() + SKILLE +
						filmer[i].getSjanger() + SKILLE +
						filmer[i].getFilmselskap();

				pw.println(filmLinje);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Feil ved skriving til fil: " + e);
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}

	public static FilmarkivADT lesFraFil(String filnavn) {
		FilmarkivADT fa = null;
		Scanner sc = null;

		try {
			sc = new Scanner(new File(filnavn));
			int antall = Integer.parseInt(sc.nextLine());

			for(int i = 0; i < antall; i++) {
				String filmLinje = sc.nextLine();
			}
		} catch(FileNotFoundException e) {
			System.out.println("Feil ved lesing fra fil: " + e);
		}

		return fa;
	}

}
