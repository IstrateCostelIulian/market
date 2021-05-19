package org.internship.market.services.mapper;

import org.internship.market.database.entity.CustomerEntity;
import org.internship.market.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CustomerMapper {

    CustomerEntity dtoToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToDto(CustomerEntity customerEntity);
}
