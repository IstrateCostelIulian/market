package org.internship.market.services.mapper;

import org.internship.market.database.entity.ProductEntity;
import org.internship.market.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO entityToDTO(ProductEntity entity);

    ProductEntity dtoToEntity(ProductDTO productDTO);

    List<ProductDTO> entitiesToDtoS(List<ProductEntity> entities);

    List<ProductEntity> dtoSToEntity(List<ProductDTO> productDTOList);
}
