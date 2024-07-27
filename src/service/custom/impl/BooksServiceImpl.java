package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BooksDao;
import dto.BooksDto;
import entity.BooksEntity;
import service.custom.BooksSevice;

public class BooksServiceImpl implements BooksSevice {

     private BooksDao booksDao = (BooksDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Books);

       @Override
    public String save(BooksDto booksDto) throws Exception {
        BooksEntity entity = getBooksEntity(booksDto);
        return booksDao.create(entity) ? "Success" : "Fail";
    }    

    @Override
    public String update(BooksDto booksDto) throws Exception {
       BooksEntity entity = getBooksEntity(booksDto);
        return booksDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer bookID) throws Exception {
         return booksDao.delete(bookID) ?  "Success" : "Fail";
    }

    @Override
    public BooksDto get(Integer bookID) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BooksDto> getAll() throws Exception {
         ArrayList<BooksEntity> booksEntitys = booksDao.getAll();
        if(booksEntitys != null && !booksEntitys.isEmpty()){
            ArrayList<BooksDto> booksDtos = new ArrayList<>();

            for (BooksEntity booksEntity : booksEntitys) {
                booksDtos.add(getBooksDto(booksEntity));
            }

            return booksDtos;
        }
        return null;
    }
    
    private BooksEntity getBooksEntity(BooksDto booksDto){
        return new BooksEntity(
                booksDto.getBookID(),
                booksDto.getTitle(),
                booksDto.getAuthor(),
                booksDto.getPublicationYear(),
                booksDto.getCategoryName(),
                booksDto.getStatus());
}
    
     private BooksDto getBooksDto(BooksEntity booksEntity){
        return  new BooksDto(
               booksEntity.getBookID(),
               booksEntity.getTitle(),
               booksEntity.getAuthor(),
               booksEntity.getPublicationYear(),
               booksEntity.getCategoryName(),
               booksEntity.getStatus()
        );
    }
}
