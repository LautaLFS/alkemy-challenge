package com.alkemy.disney.exception;

public class ParamNotFound  extends RuntimeException{
    public ParamNotFound(String error ) {
        super(error);
    }
}
