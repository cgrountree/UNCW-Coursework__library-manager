package library;

/**
 * Class that represents loans within the library manager
 * 
 * @author Cody Rountree
 *
 */
public class Loan {
	private String aBook;
	private String aPatron;
	private String dueDate;

	/**
	 * constructor for the Loan class that takes 3 parameters and initializes a loan
	 * object
	 * 
	 * @param aBook
	 *            is a given string
	 * @param aPatron
	 *            is a given string
	 * @param dueDate
	 *            is a given string
	 */
	public Loan(String aBook, String aPatron, String dueDate) {
		this.aBook = aBook;
		this.aPatron = aPatron;
		this.dueDate = dueDate;
	}

	/**
	 * Public method for getting the private data field aBook
	 * 
	 * @return aBook
	 */
	public String getBook() {
		return aBook;
	}

	/**
	 * Public method for getting the private data field aPatron
	 * 
	 * @return aPatron
	 */
	public String getPatron() {
		return aPatron;
	}

}
