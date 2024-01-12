package com.example.lmstemplate01.model;

import com.example.lmstemplate01.dto.RoleDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    private String id;
    @NonNull
    private String label;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Role(String id, @NonNull String label) {
        this.id = id;
        this.label = label;
    }

    public static Role of(String id, String label) {
        return new Role(id, label);
    }

    public static Role fromRoleDTO(RoleDTO roleDTO) {
        return Role.of(roleDTO.getId(), roleDTO.getLabel());
    }
}
