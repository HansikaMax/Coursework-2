package entity;

import java.util.Date;

public class BorrowedBooksEntity {
    
    private int borrowId;
    private int bookId;
    private String bookName;
    private int memberId;
    private Date borrowedDate;
    private Date returnDate;
    private Date actualReturnDate;
    private double lateFee;
    
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
    public Date getBorrowedDate() {
        return borrowedDate;
    }
    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Date getActualReturnDate() {
        return actualReturnDate;
    }
    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
    public double getLateFee() {
        return lateFee;
    }
    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    

}
