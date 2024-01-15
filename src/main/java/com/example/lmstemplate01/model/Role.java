package com.example.lmstemplate01.model;

import com.example.lmstemplate01.dto.RoleDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @Column(length = 100)
    private String id;
    private String label;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Role(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public static Role of(String id, String label) {
        return new Role(id, label);
    }

    public static Role fromRoleDTO(RoleDTO roleDTO) {
        return Role.of(roleDTO.getId(), roleDTO.getLabel());
    }

    public RoleDTO toRoleDTO() {
        return new RoleDTO(id, label);
    }
}
