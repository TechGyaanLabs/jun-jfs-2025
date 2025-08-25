package com.careerit.lsc.di.java;

import java.util.concurrent.ThreadLocalRandom;

public class ContactDaoImpl implements ContactDao {
    @Override
    public long getTotalContacts() {
        return ThreadLocalRandom.current().nextLong(100);
    }
}
