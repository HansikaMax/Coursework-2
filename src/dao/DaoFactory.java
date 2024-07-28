package dao;

import dao.custom.impl.BooksDaoImpl;

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
            return null; 
        default:
            return null;
    }
}

public enum DaoTypes{
    BookCategories, Books, Members;
}
}