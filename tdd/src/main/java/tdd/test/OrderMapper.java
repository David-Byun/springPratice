package tdd.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderVO getOrder(@Param("seq") Long seq);

    List<OrderVO> getOrders();
}
