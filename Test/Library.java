public class TestLibrary {
    public static void main(String[] args) {
        // إنشاء كتاب ومستعير
        PhysicalBook book = new PhysicalBook("Java Basics", "Ali", "12345");
        Borrower borrower = new Borrower("Ahmed", "20231234");

        // التحقق من توفر الكتاب
        assert book.isAvailable() : "الكتاب يجب أن يكون متوفراً في البداية";

        // استعارة الكتاب
        borrower.borrowBook(book);
        assert !book.isAvailable() : "الكتاب يجب أن يكون معاراً بعد الإعارة";

        // استرجاع الكتاب
        borrower.returnBook(book);
        assert book.isAvailable() : "الكتاب يجب أن يكون متوفراً بعد الاسترجاع";

        System.out.println("✅ جميع الاختبارات نجحت!");
    }
}
