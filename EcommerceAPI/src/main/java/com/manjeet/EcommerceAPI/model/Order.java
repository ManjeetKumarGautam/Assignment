package com.manjeet.EcommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn()
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;

    private Integer productQuantity;
}
