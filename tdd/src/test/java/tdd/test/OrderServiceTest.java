package tdd.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//service test
@Slf4j
class OrderServiceTest {

    //Mockito 해당 인터페이스 껍데기 Mock 객체를 생성
    @Mock
    private OrderMapper orderMapper;

    @Spy
    @InjectMocks
    private OrderService orderService;


    //테스트 환경에서 Mockito 어노테이션을 읽어옴
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Order 서비스 테스트")
    @Test
    public void mapper_테스트_Mockito() {

        //given
        given(orderMapper.getOrder(1L)).willReturn(new OrderVO(1L, "test"));

        //when
        OrderVO vo = orderService.getOrder(1L);

        //then
        //verify mock이 getOrder 함수가 1번 호출되면 pass
        then(orderMapper).should().getOrder(1L); // Mapper 메서드 실행 확인
        then(orderService).should().getOrder(1L); // Service 메서도 실행 확인

        assertThat(vo.getProductseq()).isEqualTo(1L);
        assertThat(vo.getProductName()).isEqualTo("test");


    }
}