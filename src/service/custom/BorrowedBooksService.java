package service.custom;

import java.util.ArrayList;


import dto.BorrowedBooksDto;
import service.SuperService;

public interface BorrowedBooksService extends SuperService {
    
     String save(BorrowedBooksDto borrowedbooksDto) throws Exception;
    String update(BorrowedBooksDto borrowedbooksDto) throws Exception;
    String delete(Integer borrowID) throws Exception;
    BorrowedBooksDto get(Integer borrowID) throws Exception;
    ArrayList<BorrowedBooksDto> getAll() throws Exception;

}
