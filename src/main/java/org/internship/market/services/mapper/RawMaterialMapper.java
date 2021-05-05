package org.internship.market.services.mapper;

import org.internship.market.database.entity.ProductEntity;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.dto.ProductDTO;
import org.internship.market.dto.RawMaterialDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RawMaterialMapper {

    RawMaterialEntity dtoToEntity(RawMaterialDTO rawMaterialDTO);

    RawMaterialDTO entityToDto(RawMaterialEntity entity);

    List<RawMaterialDTO> entityToDtoS(List<RawMaterialEntity> entities);

    List<RawMaterialEntity> dtoSToEntity(List<RawMaterialDTO> rawMaterialDTOList);

}
