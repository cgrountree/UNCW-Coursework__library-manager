package library;

import java.util.ArrayList;

/**
 * Class that represents a patron within the library manager
 * 
 * @author Cody Rountree
 *
 */
public class Patron {
	private String identifier;
	private String name;
	private static int patronCount = 1001;

	/**
	 * Constructor that takes a name and generates an identifier
	 * 
	 * @param name
	 *            is a string
	 */
	public Patron(String name) {
		this.setIdentifier("P" + patronCount);
		patronCount++;
	}

	/**
	 * Constructor that takes an identifier and a name and creates a patron object
	 * 
	 * @param identifier
	 *            is a string
	 * @param name
	 *            is a string
	 */
	public Patron(String identifier, String name) {
		this.setIdentifier(identifier);
		this.name = name;
	}

	/**
	 * Empty constructor for initializing a Patron object with empty data fields
	 */
	public Patron() {

	}

	/**
	 * Public method for getting the private data field name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Public method for getting the private data field identifier
	 * 
	 * @return identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Public method for setting the private data field identifier to the fiven
	 * value
	 * 
	 * @param identifier
	 *            is the given identifier
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
