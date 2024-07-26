package dao;

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
            return null;
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