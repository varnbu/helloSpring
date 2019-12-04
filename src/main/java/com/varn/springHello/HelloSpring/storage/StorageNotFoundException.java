package com.varn.springHello.HelloSpring.storage;

public class StorageNotFoundException extends StorageException {
    public StorageNotFoundException(String msg) {
        super(msg);
    }

    public StorageNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
