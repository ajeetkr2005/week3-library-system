package library;

public class Reservation {

    private String memberId;
    private String isbn;

    public Reservation(String memberId, String isbn) {
        this.memberId = memberId;
        this.isbn = isbn;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getIsbn() {
        return isbn;
    }
}