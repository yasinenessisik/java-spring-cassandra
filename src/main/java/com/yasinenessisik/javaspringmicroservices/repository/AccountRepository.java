package com.yasinenessisik.javaspringmicroservices.repository;

import com.yasinenessisik.javaspringmicroservices.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account,String> {

}
