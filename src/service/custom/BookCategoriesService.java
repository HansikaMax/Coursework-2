package service.custom;

import java.util.ArrayList;

import dto.BookCategoriesDto;
import service.SuperService;

public interface BookCategoriesService extends SuperService {
    
    String save(BookCategoriesDto bookCategoriesDto) throws Exception;
    String update(BookCategoriesDto bookCategoriesDto) throws Exception;
    String delete(Integer categoryID) throws Exception;
    BookCategoriesDto get(Integer categoryID) throws Exception;
    ArrayList<BookCategoriesDto> getAll() throws Exception;

}
