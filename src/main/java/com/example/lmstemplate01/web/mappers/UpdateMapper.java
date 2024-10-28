package com.example.lmstemplate01.web.mappers;

import com.example.lmstemplate01.model.user.Account;
import com.example.lmstemplate01.model.user.Role;
import com.example.lmstemplate01.web.dto.user.AccountDTO;
import com.example.lmstemplate01.web.dto.user.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * MapStruct Framework. Allow Entity to be updated partially and completely.
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UpdateMapper {

    void updateAccount(AccountDTO accountDTO, @MappingTarget Account account);

    void updateRole(RoleDTO roleDTO, @MappingTarget Role role);
}
