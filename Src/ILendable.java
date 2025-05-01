public interface ILendable {
    boolean isAvailable();
    void lend();
    void returnBook();
}
