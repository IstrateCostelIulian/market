package market.services.mapper;

import market.database.entity.OrdersEntity;
import market.dto.OrdersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrdersDTO orderEntityToOrderDTO(OrdersEntity ordersEntity);

    OrdersEntity orderDtoToOrderEntity(OrdersDTO ordersDTO);

    List<OrdersDTO> ordersToOderDtoS(List<OrdersEntity> ordersEntities);

    List<OrdersEntity> orderDtoSToOrderEntity(List<OrdersDTO> ordersDTOS);

}
