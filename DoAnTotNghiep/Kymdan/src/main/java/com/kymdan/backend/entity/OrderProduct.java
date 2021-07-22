package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "order_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "receiver", columnDefinition = "VARCHAR(250)")
    private String receiver;

    @Column(name = "receiver_phone", columnDefinition = "VARCHAR(50)")
    private String receiverPhone;

    @Column(name = "booking_date", columnDefinition = "DATE")
    private LocalDate bookingDate;

    @Column(name = "status", columnDefinition = "VARCHAR(50)")
    private String status;

    @Column(name = "total_money", columnDefinition = "VARCHAR(50)")
    private String totalMoney;

    @Column(name = "payment", columnDefinition = "VARCHAR(50)")
    private String payment;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Customer customer;

    @OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderDetail> orderDetailList;
}
