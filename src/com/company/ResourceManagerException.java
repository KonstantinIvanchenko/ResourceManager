package com.company;

public class ResourceManagerException extends Exception{
    public ResourceManagerException(){
        super();
    }

    public ResourceManagerException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceManagerException(String message){
        super(message);
    }

    public ResourceManagerException(Throwable cause){
        super(cause);
    }

}