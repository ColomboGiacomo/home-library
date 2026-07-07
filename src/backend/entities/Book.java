package backend.entities;

public class Book {
	
	public enum ReadingStatus{
		TO_READ, READING, READ;
		
		public static ReadingStatus fromInt(int i) {
			return switch (i) {
				case 1 -> TO_READ;
				case 2 -> READING;
				case 3 -> READ;
			default -> throw new IllegalArgumentException("Invalid value for ReadingStatus: " + i); 
			};
		}
	}
	
	private final int id;
	private final String title;
	private final String isbn;
	private final int publicationYear;
	private final int numberOfPages;
	private final String language;
	private final ReadingStatus readingStatus;
	private final int rating;
	private final String notes;
	private final String review;
	private final int idAuthor;
	private final int idPublisher;
	private final int idGenre;
	
	public Book(int id, String title, String isbn, int publicationYear, int numberOfPages, String language, ReadingStatus readingStatus, int rating, String notes, String review, int idAuthor, int idPublisher, int idGenre) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.numberOfPages = numberOfPages;
		this.language = language;
		this.readingStatus = readingStatus;
		this.rating = rating;
		this.notes = notes;
		this.review = review;
		this.idAuthor = idAuthor;
		this.idPublisher = idPublisher;
		this.idGenre = idGenre;
	}

	public int getId() { return id; }

	public String getTitle() { return title; }
		
	public String getIsbn() { return isbn; }

	public int getPublicationYear() { return publicationYear; }

	public int getNumberOfPages() { return numberOfPages; }

	public String getLanguage() { return language; }

	public ReadingStatus getReadingStatus() { return readingStatus; }

	public int getRating() { return rating; }
		
	public String getNotes() { return notes; }

	public String getReview() { return review; }

	public int getIdAuthor() { return idAuthor; }

	public int getIdPublisher() { return idPublisher; }

	public int getIdGenre() { return idGenre; }
	
	@Override
	public String toString() {
		return "Book{" +
				"id = " + id +
				", title = " + title +
				", isbn = " + isbn +
				", publication year = " + publicationYear +
				", number of pages = " + numberOfPages +
				", language = " + language +
				", reading status = " + readingStatus +
				", rating = " + rating +
				", notes = " + notes +
				", review = " + review +
				", id author = " + idAuthor +
				", id publisher = " + idPublisher +
				", id genre = " + idGenre +
				'}';
	}
	
	
	
}
