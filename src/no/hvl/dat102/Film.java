package no.hvl.dat102;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int aarstall;
	private Sjanger sjanger;
	private String filmselskap;

	public Film() {

	}

	public Film(int filmnr, String produsent, String tittel, int aarstall, Sjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aarstall = aarstall;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public int getAarstall() {
		return aarstall;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

}
