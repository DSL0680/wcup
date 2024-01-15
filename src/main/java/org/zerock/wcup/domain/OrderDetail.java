package org.zerock.wcup.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString(exclude = "orderEntity")
@Getter
@Table(name = "tbl_order_detail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odnum; //주문 상세 번호
    private Long pno;// 상품 번호 (메뉴 번호)
    private int qty;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;
}
