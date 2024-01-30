package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.ResultDTOPackege.BadResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.ResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.SuccessResultDTO;
import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    public final RoleService roleService;

    @PostMapping
    public RoleDTO createRole(@Valid @RequestBody RoleDTO roleDTO) {
        roleService.createRole(roleDTO);
        return roleService.getRole(roleDTO.getId());
    }

    @PatchMapping("/{id}")
    public RoleDTO updateRole(@Valid @PathVariable(value = "id") String roleId,
                                                @RequestBody RoleDTO roleDTO) {
        roleService.updateRole(roleDTO, roleId);
        return roleService.getRole(roleId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultDTO> deleteRole(@PathVariable(value = "id") String roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RoleDTO retrieveRole(@PathVariable(value = "id") String roleId) {
        return roleService.getRole(roleId);
    }

    @GetMapping("/all")
    public List<RoleDTO> getAllRoles() { // Need to retrieve PageRequest?
        return roleService.getAllRoles();
    }

    /**
     * The method throws an exception if it receives uncorrected JSON or null.
     *
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResultDTO> handleException() {
        return new ResponseEntity<>(new BadResultDTO(), HttpStatus.BAD_REQUEST);
    }

}
