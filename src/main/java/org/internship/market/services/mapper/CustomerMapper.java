package org.internship.market.services.mapper;

import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.dto.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerMapper {

    CustomerEntity dtoToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToDto(CustomerEntity customerEntity);

    List<CustomerDTO> entitiesToDtoS(List<CustomerEntity> entities);

    List<CustomerEntity> dtoSToEntity(List<CustomerDTO> productDTOList);
}
