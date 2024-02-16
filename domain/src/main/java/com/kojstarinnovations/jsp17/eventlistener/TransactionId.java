package com.kojstarinnovations.jsp17.eventlistener;

import java.util.UUID;

public class TransactionId {

    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
