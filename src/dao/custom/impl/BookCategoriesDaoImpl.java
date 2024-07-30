package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BookCategoriesDao;
import entity.BookCategoriesEntity;


public class BookCategoriesDaoImpl implements BookCategoriesDao {

    @Override
    public boolean create(BookCategoriesEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BookCategories VALUES (?,?,?)",t.getCategoryID(),t.getCategoryName(),t.getDescription() );
    }

    @Override
    public boolean update(BookCategoriesEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE BookCategories SET CategoryName=?, Description=? WHERE CategoryID=?", t.getCategoryName(),t.getDescription(),t.getCategoryID());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM BookCategories WHERE CategoryID = ?", id);
    }

    @Override
    public BookCategoriesEntity get(Integer id) throws Exception {
       return null;
    }

    @Override
    public ArrayList<BookCategoriesEntity> getAll() throws Exception {
       
         ArrayList<BookCategoriesEntity> bookCategoriesEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategories");
        while (rst.next()) {            
            BookCategoriesEntity entity = new BookCategoriesEntity(rst.getInt("CategoryID"), 
                    rst.getString("CategoryName"), rst.getString("Description"));
                    bookCategoriesEntities.add(entity);
        }
        return bookCategoriesEntities;
    }
    
}
