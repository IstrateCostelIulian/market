package org.internship.market.services.mapper;

import org.internship.market.database.entity.OrdersEntity;
import org.internship.market.dto.OrdersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrdersDTO orderEntityToOrderDTO(OrdersEntity ordersEntity);

    OrdersEntity orderDtoToOrderEntity(OrdersDTO ordersDTO);

    List<OrdersDTO> ordersToOderDtoS(List<OrdersEntity> ordersEntities);

    List<OrdersEntity> orderDtoSToOrderEntity(List<OrdersDTO> ordersDTOS);

}
