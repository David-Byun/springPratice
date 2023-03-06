package tdd.test;

import java.util.List;

public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public OrderVO getOrder(Long seq) {

        return orderMapper.getOrder(seq);
    }


    public List<OrderVO> getOrders() {

        return orderMapper.getOrders();
    }
}
