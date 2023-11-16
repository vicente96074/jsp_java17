package com.kojstarinnovations.conjava17.eventpublisher;

import java.util.UUID;

public class TransactionId {

    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
