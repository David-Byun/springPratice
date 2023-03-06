package tdd.test;

import lombok.Getter;

@Getter
public class OrderVO {

    private Long productseq;
    private String productName;

    public OrderVO() {
    }

    public OrderVO(Long productseq, String productName) {
        this.productseq = productseq;
        this.productName = productName;
    }

}
