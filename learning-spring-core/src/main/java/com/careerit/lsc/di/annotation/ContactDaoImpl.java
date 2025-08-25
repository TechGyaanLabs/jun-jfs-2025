package com.careerit.lsc.di.annotation;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadLocalRandom;

@Repository
public class ContactDaoImpl implements ContactDao {
    @Override
    public long getTotalContacts() {
        return ThreadLocalRandom.current().nextLong(100);
    }
}
