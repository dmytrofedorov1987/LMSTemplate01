package com.example.lmstemplate01.model.task;

import com.example.lmstemplate01.model.user.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title can not be empty.")
    private String title;
    private String description;
    @NotBlank
    private Status status;
    private LocalDateTime expirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    Account account;

    public Task(String title, String description, Status status, LocalDateTime expirationDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.expirationDate = expirationDate;
    }
}
