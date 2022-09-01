package com.exam.helper;

public class UserFoundException extends Exception{
    public UserFoundException() {
        super("User with this username is already in database. Try with another name");
    }
    public UserFoundException(String msg) {super(msg);}
}
