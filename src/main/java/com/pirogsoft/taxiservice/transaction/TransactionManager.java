package com.pirogsoft.taxiservice.transaction;

public interface TransactionManager {

    <T> T doInTransaction(Execution<T> execution);

    interface Execution<T> {
        T execute();
    }
}
