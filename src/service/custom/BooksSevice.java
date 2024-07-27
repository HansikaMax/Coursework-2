package service.custom;

import java.util.ArrayList;

import dto.BooksDto;
import service.SuperService;

public interface BooksSevice extends SuperService{
     String save(BooksDto booksDto) throws Exception;
    String update(BooksDto booksDto) throws Exception;
    String delete(Integer bookID) throws Exception;
    BooksDto get(Integer bookID) throws Exception;
    ArrayList<BooksDto> getAll() throws Exception;

}
