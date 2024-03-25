package com.yasinenessisik.javaspringmicroservices.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraCqlSessionFactoryBean;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.session.DefaultSessionFactory;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@EnableCassandraRepositories
@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    private String keyspaceName = "springcloud";

    private String contactPoint = "localhost";

    private int port = 9042;
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.yasinenessisik.javaspringmicroservices"};
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();//super session should be called only once
        cassandraSession.setUsername("cassandra");
        cassandraSession.setPassword("cassandra");
        return cassandraSession;
    }
}
