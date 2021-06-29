package market.services.mapper;

import market.database.entity.ProductEntity;
import market.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO entityToDTO(ProductEntity entity);

    ProductEntity dtoToEntity(ProductDTO productDTO);

    List<ProductDTO> entitiesToDtoS(List<ProductEntity> entities);

    List<ProductEntity> dtoSToEntity(List<ProductDTO> productDTOList);
}
