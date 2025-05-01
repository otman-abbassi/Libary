import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Borrower> borrowers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nنظام إدارة مكتبة رقمية");
            System.out.println("1. إضافة كتاب جديد");
            System.out.println("2. إضافة مستعير جديد");
            System.out.println("3. إعارة كتاب");
            System.out.println("4. استرجاع كتاب");
            System.out.println("5. عرض الكتب المستعارة من مستعير");
            System.out.println("6. خروج");

            System.out.print("اختر خياراً: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addBook(); break;
                case 2: addBorrower(); break;
                case 3: lendBook(); break;
                case 4: returnBook(); break;
                case 5: listBorrowedBooks(); break;
                case 6: System.exit(0);
                default: System.out.println("خيار غير صالح");
            }
        }
    }

    private static void addBook() {
        System.out.print("العنوان: ");
        String title = scanner.nextLine();
        System.out.print("المؤلف: ");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("نوع الكتاب (1: ورقي, 2: إلكتروني): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Book book = (type == 1) ? new PhysicalBook(title, author, isbn) :
                                  new EBook(title, author, isbn);
        books.add(book);
        System.out.println("تمت إضافة الكتاب.");
    }

    private static void addBorrower() {
        System.out.print("اسم المستعير: ");
        String name = scanner.nextLine();
        System.out.print("الرقم الجامعي: ");
        String id = scanner.nextLine();
        borrowers.add(new Borrower(name, id));
        System.out.println("تمت إضافة المستعير.");
    }

    private static void lendBook() {
        System.out.print("ISBN الكتاب: ");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book == null) {
            System.out.println("الكتاب غير موجود.");
            return;
        }

        System.out.print("رقم الطالب الجامعي: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("المستعير غير موجود.");
            return;
        }

        borrower.borrowBook(book);
    }

    private static void returnBook() {
        System.out.print("ISBN الكتاب: ");
        String isbn = scanner.nextLine();
        Book book = findBook(isbn);
        if (book == null) {
            System.out.println("الكتاب غير موجود.");
            return;
        }

        System.out.print("رقم الطالب الجامعي: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower == null) {
            System.out.println("المستعير غير موجود.");
            return;
        }

        borrower.returnBook(book);
    }

    private static void listBorrowedBooks() {
        System.out.print("رقم الطالب الجامعي: ");
        String id = scanner.nextLine();
        Borrower borrower = findBorrower(id);
        if (borrower != null) {
            borrower.listBorrowedBooks();
        } else {
            System.out.println("المستعير غير موجود.");
        }
    }

    private static Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getISBN().equals(isbn)) return b;
        }
        return null;
    }

    private static Borrower findBorrower(String id) {
        for (Borrower b : borrowers) {
            if (b.getUniversityId().equals(id)) return b;
        }
        return null;
    }
      }
