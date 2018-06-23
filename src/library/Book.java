package library;

/**
 * 
 * Class that represents a book in the library manager
 * 
 * @author Cody Rountree
 *
 */

public class Book {
	private String identifier;
	private String title;
	private String authorname;
	private String year;
	private static int bookCount = 1002;

	/**
	 * Constructor that takes three parameters and generates the fourth
	 * 
	 * @param title
	 *            is title of the book
	 * @param authorname
	 *            is author of the book
	 * @param year
	 *            is year the book was published
	 */
	public Book(String title, String authorname, String year) {
		this.setIdentifier("B" + bookCount);
		bookCount++;
	}

	/**
	 * Empty constructor for initializing a book with no data fields
	 */
	public Book() {

	}

	/**
	 * Constructor for book that takes four parameters.
	 * 
	 * @param identifier
	 * @param title
	 * @param authorname
	 * @param year
	 */
	public Book(String identifier, String title, String authorname, String year) {
		this.setIdentifier(identifier);
		this.title = title;
		this.authorname = authorname;
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object someObject) {
		return getIdentifier().equals(((Book) someObject).getIdentifier());
	}

	/**
	 * Public method for getting the private data field year
	 * 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Public method for getting the private data field title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Public method for getting the private data field identifier
	 * 
	 * @return
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Public method for setting the given identifier to the private data field
	 * identifier
	 * 
	 * @param identifier
	 *            is a given string
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Public method for getting the private data field authorname
	 * 
	 * @return authorname
	 */
	public String getAuthorName() {
		return authorname;
	}

}
