package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibManagerSmall {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Patron> patronList = new ArrayList<Patron>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	private String[] menuOptions;

	public static void main(String[] args) {
		LibManagerSmall lm = new LibManagerSmall();
		lm.execute();
		
	}


	public LibManagerSmall() {
		bookList = readBooks("Resources/books.txt");
		patronList = readPatrons("Resources/patrons.txt");
		loanList = readLoans("Resources/loans.txt");

		menuOptions = new String[] { "Add Book", "Add Patron", "List By Author",
				"List By Year", "Show Borrower", "Show Borrowed Books", "Return Book", "Exit" };
	}

	private void execute() {

		while (true) {
			int opt = getMenuOption();
			switch (opt) {
			case 1:
				addBook();
				break;
			case 2:
				addPatron();
				break;
			case 3:
				listByAuthor();
				break;
			case 4:
				listByYear();
				break;
			case 5:
				showBorrowers();
				break;
			case 6:
				showBorrowedBooks();
				break;
            case 7:
				returnBook();
				break;
			case 8:
				exitProgram();
				break;
			default:
				System.out.println("No such option");
			}
		}

	}

	private int getMenuOption() {

		System.out.println("Select one of the following options");
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.println("\t" + (i + 1) + ". " + menuOptions[i]);
		}

		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		return choice;
	}

	/* MAKE NO CHANGES ABOVE THIS LINE */
	/* COMPLETE ALL THE CODE STUBS BELOW */

	private void exitProgram() {
		System.out.println("Exiting..");
		System.exit(0);
	}

	/**
	 * Method that reads a given file, creates Book objects based on the contents, then adds the books to an ArrayList
	 * @param filename a given string
	 * @return the ArrayList bookArray
	 */
	private ArrayList<Book> readBooks(String filename) {
		System.out.println("Reading file "+ filename);
		ArrayList<Book> bookArray = new ArrayList<>();
		Scanner s = null;
		File theFile = new File(filename);
		try {
			s = new Scanner(theFile, "UTF-8");
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		while (s.hasNext()) {
			String currentLine = s.nextLine();
			String[] splitLine = currentLine.split(";");
			String bookId = splitLine[0].trim();
			String bookTitle = splitLine[1].trim();
			String bookAuthor = splitLine[2].trim();
			String bookDate = splitLine[3].trim();
			Book b = new Book(bookId, bookTitle, bookAuthor, bookDate);
			bookArray.add(b);
			
		}
		return bookArray;
	}

	/**
	 * Method that reads a given file, creates Patron objects based on the contents, then adds the patrons to an ArrayList
	 * @param filename a given string
	 * @return the ArrayList patronArray
	 */
	private ArrayList<Patron> readPatrons(String filename) {
		System.out.println("Reading file "+ filename);
		ArrayList<Patron> patronArray = new ArrayList<>();
		Scanner s = null;
		File theFile = new File(filename);
		try {
			s = new Scanner(theFile, "UTF-8");
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		while (s.hasNext()) {
			String currentLine = s.nextLine();
			String[] splitLine = currentLine.split("\\t");
			String patronId = splitLine[0];
			String patronName = splitLine[1];
			Patron p = new Patron(patronId, patronName);
			patronArray.add(p);
			
		}
		return patronArray;

	}

	/**
	 * Method that reads a given file, creates Loan objects based on the contents, then adds the loans to an ArrayList
	 * @param filename a given string
	 * @return the ArrayList loanArray
	 */
	private ArrayList<Loan> readLoans(String filename) {
		System.out.println("Reading file "+ filename);
		
		ArrayList<Loan> loanArray = new ArrayList<>();
		Scanner s = null;
		File theFile = new File(filename);
		try {
			s = new Scanner(theFile, "UTF-8");
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		while (s.hasNext()) {
			String currentLine = s.nextLine();
			String[] splitLine = currentLine.split(",");
			String bookId = splitLine[0];
			String patronId = splitLine[1];
			String dueDate = splitLine[2];
			Loan l = new Loan(bookId, patronId, dueDate);
			loanArray.add(l);
			
		}
		return loanArray;
	}


	/**
	 * Method that locates a book given a book ID
	 * @param bookId a given string
	 * @return the found Book object
	 */
	private Book locateBook(String bookId) {
		Book foundBook = new Book();
		for(int i = 0; i < bookList.size(); i++) {
			Book currentBook = bookList.get(i);
			if(currentBook.getIdentifier() == bookId) {
				foundBook = currentBook;
			}
		}
        System.out.println("Locating book with id = "+bookId);
		return foundBook;
	}

	/**
	 * Method that locates a patron given a patron ID
	 * @param patronId a given string
	 * @return the found Patron object
	 */
	private Patron locatePatron(String patronId) {
		Patron foundPatron = new Patron();
		for(int i = 0; i < patronList.size(); i++) {
			Patron currentPatron = patronList.get(i);
			if(currentPatron.getIdentifier() == patronId) {
				foundPatron = currentPatron;
			}
		}
        System.out.println("Locating patron with id ="+patronId);
		return foundPatron;
	}

	/**
	 * Method that asks the user to enter a patron ID and then displays the ID, title, author, and year of all the books that patron has borrowed
	 */
	private void showBorrowedBooks() {
		System.out.println("Executing showBorrowedBooks");
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a Patron ID: ");
		String aPatronId = s.next();
		for(Loan l: loanList) {
			if(l.getPatron().equalsIgnoreCase(aPatronId)){
				String bookId = l.getBook();
				for(Book b: bookList) {
					if(b.getIdentifier().equalsIgnoreCase(bookId)){
						String bookTitle = b.getTitle();
						String bookAuthor = b.getAuthorName();
						String bookYear = b.getYear();
						System.out.println("Book ID: " + bookTitle + "\tAuthor: " + bookAuthor + "\tPublication Year: " + bookYear);
					}
				}
			}

		}
        

	}

	/**
	 * Method that asks the user to enter a book ID and then displays the nae of the patron who has it borrowed
	 */
	private void showBorrowers() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a Book ID: ");
		String aBookId = s.next();
		for(Loan l: loanList) {
			if (l.getBook().equalsIgnoreCase(aBookId)){
				String patronId = l.getPatron();
				for(Patron p: patronList) {
					if(p.getIdentifier().equalsIgnoreCase(patronId)) {
						String patronName = p.getName();
						System.out.println(patronName);
					}
				}
			}
			
	

		}
        System.out.println("Executing showBorrowers");
	}

	/**
	 * Method that prompts the user to enter a minimum and maximum year, then displays all books published between those years
	 */
	private void listByYear() {
        System.out.println("Executing listByYear");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a minimum year: ");
        String minYear = s.nextLine();
        System.out.println("Enter a maximum year: ");
        String maxYear = s.nextLine();
        for(Book b: bookList) {
        	int theYear = Integer.parseInt(b.getYear());
        	int bottomYear = Integer.parseInt(minYear);
        	int topYear = Integer.parseInt(maxYear);
        	if(theYear >= bottomYear) {
        		if(theYear <= topYear) {
        			String bookId = b.getIdentifier();
        			String bookTitle = b.getTitle();
        			String bookAuthor = b.getAuthorName();
        			System.out.println(bookId + "\t" + bookTitle + "\t" + bookAuthor);
        		}
        	}
        	
        }

	}

	/**
	 * Method that prompts the user to enter an author name, then displays all books written by that author
	 */
	private void listByAuthor() {
        System.out.println("Executing listByAuthor");
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an Author's name: ");
        String aName = s.nextLine();
        for(Book b: bookList) {
        	if (b.getAuthorName().contains(aName)){
        		String bookId = b.getIdentifier();
        		String bookTitle = b.getTitle();
        		String bookYear = b.getYear();
        		System.out.println(bookId + "\t" + bookTitle + "\t" + bookYear + "\n");
        	}
        }
	}

	/**
	 * Method that prompts the user to enter a patron name, then adds that patron to the patronList and the patron text file, generating a patron ID
	 */
	private void addPatron() {
		// TODO Auto-generated method stub
        System.out.println("Executing addPatron");
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter patron name: ");
        String aName = s.nextLine();
        Patron createdPatron = new Patron(aName);
        patronList.add(createdPatron);
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Resources/patrons.txt", true)))) {
            out.println("\n" + createdPatron.getIdentifier() + "\t" + aName);
        }catch (IOException error) {
            System.err.println(error);
        }

	}

	/**
	 * Method that prompts the user to enter a book title, author, and year then adds that book to the bookList and the book text file, generating a book ID
	 */
	private void addBook() {
		// TODO Auto-generated method stub
        System.out.println("Executing addBook");
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter book title: ");
        String aTitle = s.nextLine();
        System.out.println("Please enter author name: ");
        String authorName = s.nextLine();
        System.out.println("Please enter publication year: ");
        String year = s.nextLine();
        Book createdBook = new Book(aTitle, authorName, year);
        bookList.add(createdBook);
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Resources/books.txt", true)))) {
            out.println("\n" + createdBook.getIdentifier() + "\t;\t" + aTitle + "\t;\t" + authorName +"\t;\t" + year);
        }catch (IOException error) {
            System.err.println(error);
        }

	}
    
    /**
     * Method that prompts the user to enter a book ID, then removes that book from the loanList
     */
    private void returnBook() {
		// TODO Auto-generated method stub
		System.out.println("Executing returnBook");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a book ID: ");
		String bookId = s.nextLine();
		for(Loan l: loanList) {
			if(l.getBook().equalsIgnoreCase(bookId)) {
				loanList.remove(l);
			}
		}

	}

}