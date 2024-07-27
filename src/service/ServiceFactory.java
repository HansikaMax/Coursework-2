package service;

import service.custom.impl.BooksServiceImpl;

public class ServiceFactory {
    
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

public SuperService getService(ServiceTypes type){
    switch (type) {
        case BookCategories:
            return null;
        case Books:
            return new BooksServiceImpl();
        case Members:
            return null; 
        default:
            return null;
    }
}

public enum ServiceTypes{
    BookCategories, Books, Members;
}
}
