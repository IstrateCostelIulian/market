package market.services.mapper;

import market.database.entity.RawMaterialEntity;
import market.dto.RawMaterialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RawMaterialMapper {

    @Mapping(source = "quantity", target = "stock")
    RawMaterialEntity dtoToEntity(RawMaterialDTO rawMaterialDTO);

    RawMaterialDTO entityToDto(RawMaterialEntity entity);

    List<RawMaterialDTO> entityToDtoS(List<RawMaterialEntity> entities);

    List<RawMaterialEntity> dtoSToEntity(List<RawMaterialDTO> rawMaterialDTOList);

}
