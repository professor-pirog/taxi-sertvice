package com.pirogsoft.taxiservice.transaction;

public class EmptyTransactionManager implements TransactionManager {

    @Override
    public <T> T doInTransaction(Execution<T> execution) {
        return execution.execute();
    }
}
