package tdd.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//mapper test
@Slf4j
class OrderTest {

    //Mockito 해당 인터페이스 껍데기 Mock 객체를 생성
    @Mock
    private OrderMapper orderMapper;


    //테스트 환경에서 Mockito 어노테이션을 읽어옴
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Order 매퍼 테스트")
    @Test
    public void mapper_테스트_Mockito() {

        //given
        when(orderMapper.getOrder(1L)).thenReturn(new OrderVO(1L, "test"));

        //when
        OrderVO getOrder = orderMapper.getOrder(1L);

        //then
        //verify mock이 getOrder 함수가 1번 호출되면 pass
        verify(orderMapper).getOrder(1L);
        assertThat(getOrder.getProductseq()).isEqualTo(1L);
        assertThat(getOrder.getProductName()).isEqualTo("test");

        //log
        log.info("테스트 결과 {} / {}", getOrder.getProductseq(), getOrder.getProductName());


    }
}