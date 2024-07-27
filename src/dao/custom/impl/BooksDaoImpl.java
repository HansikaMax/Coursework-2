package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BooksDao;
import entity.BooksEntity;

public class BooksDaoImpl implements BooksDao {

    @Override
    public boolean create(BooksEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Books VALUES(?,?,?,?,?)", t.getBookID(),t.getTitle(),t.getAuthor(),t.getPublicationYear(),t.getCategoryName(),t.getStatus());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Books WHERE BookID = ?", id);
    }

    @Override
    public BooksEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BooksEntity> getAll() throws Exception {
         ArrayList<BooksEntity> booksEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Books");
        while (rst.next()) {            
            BooksEntity entity = new BooksEntity(rst.getInt("BookID"), 
                    rst.getString("Title"), rst.getString("Author"), 
                    rst.getInt("PublicationYear"), rst.getString("Category Name"),rst.getString("status"));
            booksEntities.add(entity);
        }
        return booksEntities;
    }

    @Override
    public boolean update(BooksEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Books SET Title=?,Author=?,PublicationYear=?,CategoryName=? WHERE BookID=?",t.getTitle(),t.getAuthor(),t.getPublicationYear(),t.getCategoryName(),t.getBookID());
    }

}
