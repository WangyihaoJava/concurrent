package com.example.demo.observer;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangyihao
 * @ClassName Item
 * @date 2021/5/14 16:19
 * @Description
 */
@Data
public class Item {
     //商品ID
            private long id;
 //商品数量
       private int quantity;
 //商品单价
       private BigDecimal price;
 //商品优惠
       private BigDecimal couponPrice;
 //商品运费
       private BigDecimal deliveryPrice;
}
