import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        // Initialize variables
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        PrintWriter outputStream = null;
        int choice;

        // Create sample library items
        Book Book1 = new Book("To Kill A Mocking Bird", 2015, "Harper Lee", "4834840");
        DVD DVD1 = new DVD("Finding Nemo", 2003, "Andrew Stanton", 100);
        CD CD1 = new CD("DAMN", 2017, "Kendrick Lamar", 8);
        Book Book2 = new Book("IDK", 2013, "ME", "4834839");

        // Add sample library items to the list
        libraryItems.add(Book1);
        libraryItems.add(CD1);
        libraryItems.add(DVD1);
        libraryItems.add(Book2);

        // Menu loop
        do {
            // Print menu options
            System.out.println("\n------Menu------");
            System.out.println("1 - Display Entire Library Catalog");
            System.out.println("2 - Display Books only");
            System.out.println("3 - Display CDs only");
            System.out.println("4 - Display DVDs only");
            System.out.println("5 - Search by Title");
            System.out.println("6 - Add a new item");
            System.out.println("7 - Remove an item");
            System.out.println("8 - Export Library Catalog to CSV");
            System.out.println("9 - Import new items from a CSV");
            System.out.println("10 - Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            // Option handling
            if (choice == 1) {
                // Display Entire Library Catalog
                for (LibraryItem items : libraryItems) {
                    System.out.print(items.toString());
                }
            } else if (choice == 2) {
                // Display Books only
                System.out.println("\nBooks: ");
                for (LibraryItem items : libraryItems) {
                    if (items instanceof Book) {
                        System.out.print(items);
                    }
                }
            } else if (choice == 3) {
                // Display CDs only
                System.out.println("\nCDs: ");
                for (LibraryItem items : libraryItems) {
                    if (items instanceof CD) {
                        System.out.print(items);
                    }
                }
            } else if (choice == 4) {
                // Display DVDs only
                System.out.println("\nDVDs: ");
                for (LibraryItem items : libraryItems) {
                    if (items instanceof DVD) {
                        System.out.print(items);
                    }
                }
            } else if (choice == 5) {
                // Search by Title
                System.out.print("Enter search statement: ");
                String searchStatement = scan.next();
                boolean found = false;
                System.out.println("Search Results:");
                for (LibraryItem item : libraryItems) {
                    if (item.getTitle().contains(searchStatement)) {
                        System.out.println(item);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No items found matching the search statement.");
                }
            } else if (choice == 6) {
                // Add a new item
                System.out.print("Enter item type: ");
                String itemType = scan.next();

                // Handle different item types
                if (itemType.equalsIgnoreCase("Book")) {
                    scan.nextLine(); // Consume the newline character left by next()
                    System.out.print("Enter title: ");
                    String title = scan.nextLine(); // Use nextLine() to capture the full title
                    System.out.print("Enter year: ");
                    int year = scan.nextInt();
                    scan.nextLine(); // Consume the newline character after nextInt()
                    System.out.print("Enter author: ");
                    String author = scan.nextLine(); // Use nextLine() to capture the full author name
                    System.out.print("Enter ISBN: ");
                    String ISBN = scan.nextLine(); // Use nextLine() to capture the full ISBN
                    Book newBook = new Book(title, year, author, ISBN);
                    libraryItems.add(newBook);
                    System.out.println("Book added.");
                } else if (itemType.equalsIgnoreCase("CD")) {
                    scan.nextLine(); // Consume the newline character left by next()
                    System.out.print("Enter title: ");
                    String title = scan.nextLine(); // Use nextLine() to capture the full title
                    System.out.print("Enter year: ");
                    int year = scan.nextInt();
                    scan.nextLine(); // Consume the newline character after nextInt()
                    System.out.print("Enter artist: ");
                    String artist = scan.nextLine(); // Use nextLine() to capture the full artist name
                    System.out.print("Enter number of tracks: ");
                    int tracks = scan.nextInt();
                    scan.nextLine(); // Consume the newline character after nextInt()
                    CD newCD = new CD(title, year, artist, tracks);
                    libraryItems.add(newCD);
                    System.out.println("CD added.");
                } else if (itemType.equalsIgnoreCase("DVD")) {
                    scan.nextLine(); // Consume the newline character left by next()
                    System.out.print("Enter title: ");
                    String title = scan.nextLine(); // Use nextLine() to capture the full title
                    System.out.print("Enter year: ");
                    int year = scan.nextInt();
                    scan.nextLine(); // Consume the newline character after nextInt()
                    System.out.print("Enter director: ");
                    String director = scan.nextLine(); // Use nextLine() to capture the full director name
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scan.nextInt();
                    scan.nextLine(); // Consume the newline character after nextInt()
                    DVD newDVD = new DVD(title, year, director, duration);
                    libraryItems.add(newDVD);
                    System.out.println("DVD added.");
                } else {
                    System.out.println("Invalid item type.");
                }


            } else if (choice == 7) {
                // Remove an item
                try {
                    System.out.print("Enter the title of the item to remove: ");
                    scan.nextLine(); // Consume newline
                    String titleRemove = scan.nextLine();
                    boolean remove = false;
                    for (int i = 0; i < libraryItems.size(); i++) {
                        if (libraryItems.get(i).getTitle().equals(titleRemove)) {
                            libraryItems.remove(i);
                            System.out.println("Item removed successfully.");
                            remove = true;
                            break;
                        }
                    }
                    if (!remove) {
                        System.out.println("No item found with title: " + titleRemove);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input.");
                    System.exit(0);
                }
            } else if (choice == 8) {
                // Export Library Catalog to CSV
                try {
                    outputStream = new PrintWriter(new FileOutputStream("output.csv"));
                    for (LibraryItem item : libraryItems)
                        if (item instanceof Book) {
                            Book book = (Book) item;
                            outputStream.println("Book," + book.getTitle() + "," + book.getYear() + "," + book.getAuthor() + "," + book.getIsbn());
                        } else if (item instanceof CD) {
                            CD cd = (CD) item;
                            outputStream.println("CD," + cd.getTitle() + "," + cd.getYear() + "," + cd.getArtist() + "," + cd.getNumOfTracks());
                        } else if (item instanceof DVD) {
                            DVD dvd = (DVD) item;
                            outputStream.println("DVD," + dvd.getTitle() + "," + dvd.getYear() + "," + dvd.getDirector() + "," + dvd.getDuration());
                        }
                    System.out.println("Library added to CSV");
                } catch (FileNotFoundException e) {
                    System.err.println("File unable to be opened");
                    System.exit(0);
                }
                outputStream.close();
            } else if (choice == 9) {
                // Import new items from a CSV
                Scanner inputStream = null;
                try {
                    inputStream = new Scanner(new FileInputStream("Library.csv"));
                    inputStream.useDelimiter("(\\n)|,");
                    while (inputStream.hasNext()) {
                        String type = inputStream.next();
                        if (type.equalsIgnoreCase("Book")) {
                            String title = inputStream.next();
                            int year = inputStream.nextInt();
                            String author = inputStream.next();
                            String isbn = inputStream.next();
                            Book aBook = new Book(title, year, author, isbn);
                            libraryItems.add(aBook);
                            System.out.println("Added Book: " + aBook);
                        } else if (type.equalsIgnoreCase("CD")) {
                            String title = inputStream.next();
                            int year = inputStream.nextInt();
                            String artist = inputStream.next();
                            int tracks = inputStream.nextInt();
                            CD aCD = new CD(title, year, artist, tracks);
                            libraryItems.add(aCD);
                            System.out.println("Added CD: " + aCD);
                        } else if (type.equalsIgnoreCase("DVD")) {
                            String title = inputStream.next();
                            int year = inputStream.nextInt();
                            String director = inputStream.next();
                            int duration = inputStream.nextInt();
                            DVD aDVD = new DVD(title, year, director, duration);
                            libraryItems.add(aDVD);
                            System.out.println("Added DVD: " + aDVD);
                        }
                    }
                    System.out.println("Library items added from CSV file.");
                } catch (FileNotFoundException e) {
                    System.err.println("File unable to be opened");
                    System.exit(0);
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } else if (choice == 10) {
                // Exit
                System.out.println("Goodbye");
                break;
            } else {
                // Invalid choice
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

    }
}
