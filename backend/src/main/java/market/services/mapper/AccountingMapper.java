package market.services.mapper;

import market.database.entity.AccountingEntity;
import market.dto.AccountingDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountingMapper {

    AccountingDTO entityToDto(AccountingEntity entity);

    AccountingEntity dtoToEntity(AccountingDTO dto);

    List<AccountingDTO> entitiesToDtoS(List<AccountingEntity> entities);

}
