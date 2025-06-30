package com.example.lmstemplate01.model.user;

import com.example.lmstemplate01.model.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username can not be empty and should be unique.")
    private String username;

    @NotBlank
    private String password;

    private String confirmPassword;

    @NotBlank
    @Email(message = "Email should be valid and unique.")
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    private List<Task> tasks = new ArrayList<>();

    public Account() {
    }

    public Account(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);

    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setAccount(this);
    }
}
