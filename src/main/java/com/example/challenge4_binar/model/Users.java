package com.example.challenge4_binar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String email_address;
    @Setter
    @Getter
    private String password;

}
