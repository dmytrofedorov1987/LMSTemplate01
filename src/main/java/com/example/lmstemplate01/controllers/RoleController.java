package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.services.RoleService;
import com.example.lmstemplate01.utils.MLSTemplateError;
import com.example.lmstemplate01.utils.MLSTemplateRuntimeException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    public final RoleService roleService;

    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        try {
            roleService.createRole(roleDTO);
            return ResponseEntity.ok(roleService.getRole(roleDTO.getId()));
        } catch (MLSTemplateRuntimeException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.BAD_REQUEST.value(),
                            "Incorrect data."));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateRole(@Valid @PathVariable(value = "id") String roleId,
                                        @RequestBody RoleDTO roleDTO) {
        try {
            RoleDTO roleDto = roleService.updateRole(roleDTO, roleId);
            return ResponseEntity.ok(roleDto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Role with id " + roleId + " is not found."));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable(value = "id") String roleId) {
        try {
            roleService.deleteRole(roleId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (MLSTemplateRuntimeException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Role with id " + roleId + " is not found."));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveRole(@PathVariable(value = "id") String roleId) {
        try {
            RoleDTO roleDTO = roleService.getRole(roleId);
            return new ResponseEntity<>(roleDTO, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Role with id " + roleId + " is not found."));
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> list = roleService.getAllRoles();
        return ResponseEntity.ok(list);
    }

}
