package service;

import service.custom.impl.BookCategoriesServiceImpl;
import service.custom.impl.BooksServiceImpl;
import service.custom.impl.MembersServiceImpl;

public class ServiceFactory {
    
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

public SuperService getService(ServiceType type){
    switch (type) {
        case BookCategories:
            return new BookCategoriesServiceImpl();
        case Books:
            return new BooksServiceImpl();
        case Members:
            return new MembersServiceImpl(); 
        default:
            return null;
    }
}

public enum ServiceType{
    BookCategories, Books, Members;
}
}
