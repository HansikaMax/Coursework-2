package dao;

import dao.custom.impl.BooksDaoImpl;
import dao.custom.impl.MembersDaoImpl;

public class DaoFactory {
    
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
}

public SuperDao getDao(DaoTypes type){
    switch (type) {
        case BookCategories:
            return null;
        case Books:
            return new BooksDaoImpl();
        case Members:
            return new MembersDaoImpl(); 
        default:
            return null;
    }
}

public enum DaoTypes{
    BookCategories, Books, Members;
}
}