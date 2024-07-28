package dto;

public class BooksDto {
    private int bookID;
    private String title;
    private String author;
    private int publicationYear;
    private String categoryName;
    private String status;
   
    public BooksDto() {
    }

    public BooksDto(int bookID, String title, String author, int publicationYear, String categoryName, String status) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.categoryName = categoryName;
        this.status=status;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;   
    }
    
    public String getStatus(){
        status="available";
        return status;
    }
}
