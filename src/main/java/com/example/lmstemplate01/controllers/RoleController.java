package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.BadResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.ResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.SuccessResultDTO;
import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {
    public final RoleService roleService;

    @PostMapping
    public ResponseEntity<ResultDTO> createRole(RoleDTO roleDTO) {
        roleService.createRole(roleDTO);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultDTO> updateRole(@PathVariable(value = "id") String roleId,
                                                @RequestBody RoleDTO roleDTO) {
        roleService.updateRole(roleDTO, roleId);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
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
