package BookLinkedList;

class Node {
    Book data; // Book object
    Node next; // Reference to the next node

    public Node(Book Book) {
        data = Book;
        next = null;
    }
}

// Book class represents a Book object
class Book {
    String title;
    String author;
    String publicationYear;


    public Book(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}

// LinkedList class represents the linked list data structure
class LinkedList {
    Node head; // Reference to the first node in the linked list
    Node end;

    // Method to add a Book to the linked list
    public void addBook(Book Book) {
        Node newNode = new Node(Book);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        end = newNode;
    }

    // Method to display the Book information in the linked list
    public void displayBooks() {
        Node current = head;
        while (current != null) {
            Book Book = current.data;
            System.out.println("title: " + Book.title);
            System.out.println("author: " + Book.author);
            System.out.println("publicationYear: " + Book.publicationYear);
            System.out.println("----------------------");
            current = current.next;
        }
    }

    // Method to print the Book information in reverse
    public void printBooksInReverse() {
        reversePrint(head);

    }

    public void reversePrint(Node current) {
        if(current == null) return;

        reversePrint(current.next);

        Book Book = current.data;
            System.out.println("title: " + Book.title);
            System.out.println("author: " + Book.author);
            System.out.println("publicationYear: " + Book.publicationYear);
            System.out.println("----------------------");
    }


    public void addBookAtBeginning(Book book) {
        Node node = new Node(book);
        if(head == null) {
            end = node;
        } else {
            Node temp = head;
            node.next = temp;
        }
        head = node;

    }

    public Boolean removeBookAtBeginning() {
        if(head == null) return false;
        head = head.next;

        if(head == null) end = null;

        return true;
    }

    public Boolean removeBookAtEnd() {
        if (head == null) return false;

        if (head == end) {
            head = null;
            end = null;
        } else {
            Node temp = head;
            while (temp.next != end) {
                temp = temp.next;
            }
            temp.next = null;
            end = temp;
        }

        return true;
    }

    public void addBookAtEnd(Book book) {
        Node node = new Node(book);
        if(end == null) {
            head = node;
        } else {
            end.next = node;
        }
        end = node;
    }    
}

public class Main {
    public static void main(String[] args) {
        // Create at least 6 books
        Book book1 = new Book("Title 1", "Author 1", "2020");
        Book book2 = new Book("Title 2", "Author 2", "2019");
        Book book3 = new Book("Title 3", "Author 3", "2018");
        Book book4 = new Book("Title 4", "Author 4", "2017");
        Book book5 = new Book("Title 5", "Author 5", "2016");
        Book book6 = new Book("Title 6", "Author 6", "2015");

        // Create a linked list to store the books
        LinkedList bookList = new LinkedList();

        // Add books to the linked list
        bookList.addBook(book1);
        bookList.addBook(book2);
        bookList.addBook(book3);
        bookList.addBook(book4);
        bookList.addBook(book5);
        bookList.addBook(book6);

        // Print the list of books
        System.out.println("Books in the list:");
        bookList.displayBooks();

        // Add a book to the beginning of the list
        Book newBookAtBeginning = new Book("New Book at Beginning", "New Author", "2023");
        bookList.addBookAtBeginning(newBookAtBeginning);
        System.out.println("\nAfter adding a book at the beginning:");
        bookList.displayBooks();

        // Add a book to the end of the list
        Book newBookAtEnd = new Book("New Book at End", "New Author", "2024");
        bookList.addBookAtEnd(newBookAtEnd);
        System.out.println("\nAfter adding a book at the end:");
        bookList.displayBooks();

        // Remove a book from the beginning of the list
        bookList.removeBookAtBeginning();
        System.out.println("\nAfter removing a book from the beginning:");
        bookList.displayBooks();

        // Remove a book from the end of the list
        bookList.removeBookAtEnd();
        System.out.println("\nAfter removing a book from the end:");
        bookList.displayBooks();

        // Print the list of books in reverse order
        System.out.println("\nBooks in reverse order:");
        bookList.printBooksInReverse();
    }
}