package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BorrowedBooksDao;
import dto.BorrowedBooksDto;
import entity.BorrowedBooksEntity;
import service.custom.BorrowedBooksService;

public class BorrowedBooksServiceImpl implements BorrowedBooksService{

    private BorrowedBooksDao borrowedbooksDao = (BorrowedBooksDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BorrowedBooks);

    @Override
    public String save(BorrowedBooksDto borrowedbooksDto) throws Exception {
        BorrowedBooksEntity entity = getBorrowedBooksEntity( borrowedbooksDto);
        return borrowedbooksDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(BorrowedBooksDto borrowedbooksDto) throws Exception {
        BorrowedBooksEntity entity = getBorrowedBooksEntity(borrowedbooksDto);
        return borrowedbooksDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer borrowID) throws Exception {
        return borrowedbooksDao.delete(borrowID) ?  "Success" : "Fail";
    }

    @Override
    public BorrowedBooksDto get(Integer borrowID) throws Exception {
       return null;
    }

    @Override
    public ArrayList<BorrowedBooksDto> getAll() throws Exception {
        ArrayList<BorrowedBooksEntity> borrowedbooksEntitys = borrowedbooksDao.getAll();
        if(borrowedbooksEntitys != null && !borrowedbooksEntitys.isEmpty()){
            ArrayList<BorrowedBooksDto> borrowedbooksDtos = new ArrayList<>();

            for (BorrowedBooksEntity borrowedbooksEntity : borrowedbooksEntitys) {
                borrowedbooksDtos.add(getBorrowedBooksDto(borrowedbooksEntity));
            }

            return borrowedbooksDtos;
        }
        return null;
        
    }
    private BorrowedBooksEntity getBorrowedBooksEntity(BorrowedBooksDto borrowedbooksDto){
        return new BorrowedBooksEntity(
               borrowedbooksDto.getBorrowId(),
               borrowedbooksDto.getBookId(),
               borrowedbooksDto.getBookName(),
               borrowedbooksDto.getMemberId(),
               borrowedbooksDto.getBorrowedDate(),
               borrowedbooksDto.getReturnDate(),
               borrowedbooksDto.getActualReturnDate(),
               borrowedbooksDto.getLateFee()
        );
    }

    private BorrowedBooksDto getBorrowedBooksDto(BorrowedBooksEntity borrowedBooksentity){
        return new BorrowedBooksDto(
            borrowedBooksentity.getBorrowId(),
            borrowedBooksentity.getBookId(),
             borrowedBooksentity.getBookName(),
             borrowedBooksentity.getMemberId(),
              borrowedBooksentity.getBorrowedDate(),
              borrowedBooksentity.getReturnDate(),
              borrowedBooksentity.getActualReturnDate(),
              borrowedBooksentity.getLateFee());
    }

}
