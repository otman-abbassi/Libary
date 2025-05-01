import java.util.ArrayList;

public class Borrower {
    private String name;
    private String universityId;
    private ArrayList<Book> borrowedBooks;

    public Borrower(String name, String universityId) {
        this.name = name;
        this.universityId = universityId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.lend();
            borrowedBooks.add(book);
            System.out.println("تمت إعارة الكتاب: " + book.getTitle());
        } else {
            System.out.println("الكتاب غير متوفر حالياً.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println("تم استرجاع الكتاب: " + book.getTitle());
        } else {
            System.out.println("هذا الكتاب غير مستعار من هذا المستعير.");
        }
    }

    public void listBorrowedBooks() {
        System
