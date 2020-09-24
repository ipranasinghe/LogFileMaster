package lk.slt.soa.logfilesmaster.storage;

import lk.slt.soa.logfilesmaster.storage.StorageException;

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
