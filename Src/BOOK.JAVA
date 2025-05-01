public abstract class Book implements ILendable {
    protected String title;
    protected String author;
    protected String ISBN;
    protected boolean isBorrowed;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public boolean isAvailable() {
        return !isBorrowed;
    }

    public void lend() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return getType() + ": " + title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}
