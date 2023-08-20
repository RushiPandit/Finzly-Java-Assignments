import java.util.Scanner;

class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of Book and DVD classes
        Book book = new Book("The Alchemist", "Paulo Coelho", 1988);
        DVD dvd = new DVD("The Shawshank Redemption", 1994, 142);

        // Display information about the book and DVD using the displayinfo() method
        book.displayinfo();
        dvd.displayinfo();

        // Create instances of LibraryMember subclasses
        StudentMember studentMember = new StudentMember(123456, "John Doe");
        FacultyMember facultyMember = new FacultyMember(789012, "Jane Doe");

        // Demonstrate abstraction by calling the borrowitem() method
        studentMember.borrowitem(book);
        facultyMember.borrowitem(dvd);
    }
}

class LibraryItem {

    protected String title;
    protected int itemID;

    public LibraryItem(String title, int itemID) {
        this.title = title;
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public abstract void displayinfo();
}

class Book extends LibraryItem {

    private String author;

    public Book(String title, String author, int itemID) {
        super(title, itemID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void displayinfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Item ID: " + itemID);
    }
}

class DVD extends LibraryItem {

    private int duration;

    public DVD(String title, int duration, int itemID) {
        super(title, itemID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void displayinfo() {
        System.out.println("Title: " + title);
        System.out.println("Duration: " + duration);
        System.out.println("Item ID: " + itemID);
    }
}

abstract class LibraryMember {

    protected int memberID;
    protected String name;

    public LibraryMember(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public abstract void borrowitem(LibraryItem item);
}

class StudentMember extends LibraryMember {

    public StudentMember(int memberID, String name) {
        super(memberID, name);
    }

    @Override
    public void borrowitem(LibraryItem item) {
        System.out.println("Student " + name + " borrowed " + item.getTitle());
    }
}

class FacultyMember extends LibraryMember {

    public FacultyMember(int memberID, String name) {
        super(memberID, name);
    }

    @Override
    public void borrowitem(LibraryItem item) {
        System.out.println("Faculty " + name + " borrowed " + item.getTitle());
    }
}
