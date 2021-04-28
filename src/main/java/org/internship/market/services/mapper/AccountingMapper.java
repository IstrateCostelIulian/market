package org.internship.market.services.mapper;

import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountingMapper {

    AccountingDTO entityToDto(AccountingEntity entity);

    AccountingEntity dtoToEntity(AccountingDTO dto);

    List<AccountingDTO> entitiesToDtoS(List<AccountingEntity> entities);

}
