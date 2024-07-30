package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BookCategoriesDao;
import dto.BookCategoriesDto;
import entity.BookCategoriesEntity;
import service.custom.BookCategoriesService;

public class BookCategoriesServiceImpl implements BookCategoriesService{

     private BookCategoriesDao bookCategoriesDao = (BookCategoriesDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BookCategories);


    @Override
    public String save(BookCategoriesDto bookCategoriesDto) throws Exception {
        BookCategoriesEntity entity = getBookCategoriesEntity(bookCategoriesDto);
        return bookCategoriesDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(BookCategoriesDto bookCategoriesDto) throws Exception {
        BookCategoriesEntity entity = getBookCategoriesEntity(bookCategoriesDto);
        return bookCategoriesDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer categoryID) throws Exception {
        return bookCategoriesDao.delete(categoryID) ?  "Success" : "Fail";
    }

    @Override
    public BookCategoriesDto get(Integer categoryID) throws Exception {
       return null;
    }

    @Override
    public ArrayList<BookCategoriesDto> getAll() throws Exception {
        
         ArrayList<BookCategoriesEntity> bookCategoriesEntitys = bookCategoriesDao.getAll();
        if(bookCategoriesEntitys != null && !bookCategoriesEntitys.isEmpty()){
            ArrayList<BookCategoriesDto> bookCategoriesDtos = new ArrayList<>();

            for (BookCategoriesEntity bookCategoriesEntity : bookCategoriesEntitys) {
                bookCategoriesDtos.add(getBookCategoriesDto(bookCategoriesEntity));
            }

            return bookCategoriesDtos;
        }
        return null;

    }
    
    private BookCategoriesEntity getBookCategoriesEntity(BookCategoriesDto bookCategoriesDto){
        return new BookCategoriesEntity(
            bookCategoriesDto.getCategoryID(),
            bookCategoriesDto.getCategoryName(),
            bookCategoriesDto.getDescription()
        );
    }

    private BookCategoriesDto getBookCategoriesDto(BookCategoriesEntity bookCategoriesEntity){  
        return new BookCategoriesDto(
            bookCategoriesEntity.getCategoryID(),
            bookCategoriesEntity.getCategoryName(),
            bookCategoriesEntity.getDescription()
            );
    }
}
