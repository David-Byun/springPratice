package tdd.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;


@MybatisTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderMybatisTestTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    @DisplayName("Order Mapper Test")
    public void mybatis_Mapper_XML_테스트() throws Exception {

        //given
        Long seq = 1L;

        //when
        OrderVO order = orderMapper.getOrder(seq);

        //then
        assertThat(order.getProductseq()).isEqualTo(1L);

        //log
        log.info("테스트 결과 {} / {}", order.getProductseq(), order.getProductName());
    }
}