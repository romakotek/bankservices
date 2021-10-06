package com.example.bankservices.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String address;
    private int rating = 2;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts;

}
