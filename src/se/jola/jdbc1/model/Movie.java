package se.jola.jdbc1.model;

public final class Movie {

	private final int id;

	private final String title;

	private final String productionYear;

	private final String genre;

	public Movie(int id, String title, String productionYear, String genre) {
		this.id = id;
		this.title = title;
		this.productionYear = productionYear;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getProductionYear() {
		return productionYear;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj instanceof Movie) {
			Movie other = (Movie) obj;
			return id == other.getId() && title.equals(other.getTitle())
					&& productionYear.equals(other.getProductionYear()) && genre.equals(other.getGenre());
		}

		return false;
	}

	@Override
	public int hashCode() {

		int hashCode = 1;

		hashCode += 37 * title.hashCode();
		hashCode += 37 * productionYear.hashCode();

		return hashCode;
	}

}
