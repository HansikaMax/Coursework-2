package dao.custom.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.CrudUtil;
import dao.custom.BorrowedBooksDao;
import entity.BorrowedBooksEntity;

public class BorrowedBooksDaoImpl implements BorrowedBooksDao{

    @Override
    public boolean create(BorrowedBooksEntity t) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date bdate = sdf.parse(t.getBorrowedDate());
         Date rdate = sdf.parse(t.getReturnDate());
         Date ardate = sdf.parse(t.getActualReturnDate());

        return CrudUtil.executeUpdate("INSERT INTO BorrowedBooks VALUES(?,?,?,?,?,?,?,?)",t.getBorrowId(),t.getBookId(),t.getBookName(),t.getMemberId(),new java.sql.Date(bdate.getTime()),new java.sql.Date(rdate.getTime()),new java.sql.Date(ardate.getTime()),t.getLateFee());
    }

    @Override
    public boolean update(BorrowedBooksEntity t) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date bdate = sdf.parse(t.getBorrowedDate());
         Date rdate = sdf.parse(t.getReturnDate());
         Date ardate = sdf.parse(t.getActualReturnDate());

        return CrudUtil.executeUpdate("UPDATE BorrowedBooks SET BookID=?, BookName=?, MemberID=?, BorrowDate=?, ReturnDate=?, ActualReturnDate=?, Latefee=? WHERE BorrowID=?", t.getBookId(),t.getBookName(),t.getMemberId(),new java.sql.Date(bdate.getTime()),new java.sql.Date(rdate.getTime()),
        new java.sql.Date(ardate.getTime()),t.getLateFee(),t.getBorrowId() );
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM BorrowedBooks WHERE BorrowID = ?", id);
    }

    @Override
    public BorrowedBooksEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BorrowedBooksEntity> getAll() throws Exception {
        ArrayList<BorrowedBooksEntity> borrowedbooksEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BorrowedBooks");
        while (rst.next()) {           
            Date bDate=rst.getDate("BorrowDate"); 
            Date rDate=rst.getDate("ReturnDate"); 
            Date arDate=rst.getDate("ActualReturnDate"); 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bdateString = sdf.format(bDate);
            String rdateString = sdf.format(rDate);
            String ardateString = sdf.format(arDate);
            
            BorrowedBooksEntity entity = new BorrowedBooksEntity(rst.getInt("BorrowID"), 
                    rst.getInt("BookID"), rst.getString("BookName"), 
                    rst.getInt("MemberID"), bdateString,rdateString,ardateString,rst.getDouble("Latefee"));
                    borrowedbooksEntities.add(entity);
        }
        return borrowedbooksEntities;
    }
    
}
