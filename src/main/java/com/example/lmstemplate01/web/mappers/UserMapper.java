package com.example.lmstemplate01.web.mappers;

import com.example.lmstemplate01.model.user.Account;
import com.example.lmstemplate01.web.dto.user.AccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * MapStruct Framework for Model<->DTO and DTO<->Model
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDto(Account account);

    List<AccountDTO> toDto(List<Account> accounts);
}
