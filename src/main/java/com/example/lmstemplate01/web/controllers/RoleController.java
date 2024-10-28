package com.example.lmstemplate01.web.controllers;

import com.example.lmstemplate01.model.exceptions.MLSTemplateError;
import com.example.lmstemplate01.model.exceptions.MLSTemplateRuntimeException;
import com.example.lmstemplate01.services.userService.RoleService;
import com.example.lmstemplate01.web.dto.user.RoleDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    public final RoleService roleService;
    private final static Integer CURRENT_PAGE_DEFAULT = 0;
    private final static Integer PAGE_SIZE_DEFAULT = 10;

    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        try {
            RoleDTO roleDto = roleService.createRole(roleDTO);
            return ResponseEntity.ok(roleDto);
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
            return ResponseEntity.ok(new MLSTemplateError(HttpStatus.OK.value(),
                    "The role has been deleted."));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Role with id " + roleId + " is not found."));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveRole(@PathVariable(value = "id") String roleId) {
        try {
            RoleDTO roleDTO = roleService.getRole(roleId);
            return ResponseEntity.ok(roleDTO);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Role with id " + roleId + " is not found."));
        }
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllRoles(@RequestParam(name = "page_number") Optional<Integer> page) {
        int currentPage = page.orElse(CURRENT_PAGE_DEFAULT);
        if (currentPage < roleService.totalPages(PAGE_SIZE_DEFAULT)) {
            return ResponseEntity.ok(roleService.getAllRoles(PageRequest.of(currentPage, PAGE_SIZE_DEFAULT)));
        }
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.BAD_REQUEST.value(),
                            "Page Number is not correct."));
    }

}
