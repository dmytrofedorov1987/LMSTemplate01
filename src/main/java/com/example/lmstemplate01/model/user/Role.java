package com.example.lmstemplate01.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @Column(length = 100)
    private String id;
    private String label;
    @ManyToMany(mappedBy = "roles")
    private Set<Account> users = new HashSet<>();

    public Role(String id, String label) {
        this.id = id;
        this.label = label;
    }
}
