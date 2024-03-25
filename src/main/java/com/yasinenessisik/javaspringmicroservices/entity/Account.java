package com.yasinenessisik.javaspringmicroservices.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "accounts")
public class Account {
    public Account(String id) {
        this.id = id;
    }
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column(value = "username")
    private String username;
    @Column(value = "email")
    private String email;
    @Column(value = "password")
    private String password;
    @Column(value = "created_at")
    private Date createdAt;
    @Column(value = "is_active")
    private boolean isActive;
}
