package dto;

public class BorrowedBooksDto {
    private int borrowId;
    private int bookId;
    private String bookName;
    private int memberId;
    private String borrowedDate;
    private String  returnDate;
    private String  actualReturnDate;
    private double lateFee;

    
   
    public BorrowedBooksDto(int borrowId, int bookId, String bookName, int memberId, String borrowedDate,
            String returnDate, String actualReturnDate, double lateFee) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.memberId = memberId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.lateFee = lateFee;
    }
    public int getBorrowId() {
        return borrowId;
    }
    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getBorrowedDate() {
        return borrowedDate;
    }
    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public String getActualReturnDate() {
        return actualReturnDate;
    }
    public void setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
    public double getLateFee() {
        return lateFee;
    }
    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    
    
   
    
    

    
}
