public class PhysicalBook extends Book {
    public PhysicalBook(String title, String author, String ISBN) {
        super(title, author, ISBN);
    }

    @Override
    public String getType() {
        return "كتاب ورقي";
    }
}
