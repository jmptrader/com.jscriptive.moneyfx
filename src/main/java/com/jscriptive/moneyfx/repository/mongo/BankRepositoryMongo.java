package com.jscriptive.moneyfx.repository.mongo;

import com.jscriptive.moneyfx.model.Bank;
import com.jscriptive.moneyfx.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by jscriptive.com on 16/11/14.
 */
@Repository
public class BankRepositoryMongo implements BankRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Bank findByName(String name) {
        return mongoTemplate.findOne(new Query(where("name").is(name)), Bank.class);
    }

    @Override
    public Collection<Bank> findAll() {
        return mongoTemplate.findAll(Bank.class);
    }

    @Override
    public void insert(Bank bank) {
        mongoTemplate.insert(bank);
    }

}
