package com.example.demo.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author wangyihao
 * @ClassName NormalUserCart
 * @date 2021/5/14 16:18
 * @Description
 */
public class NormalUserCart {

    public Cart process(long userId, Map<Long, Integer> items) {
      /*   Cart cart = new Cart();

         //把Map的购物车转换为Item列表
         List<Item> itemList = new ArrayList<>();
         items.entrySet().stream().forEach(entry -> {
         Item item = new Item();
         item.setId(entry.getKey());
         item.setPrice(Db.getItemPrice(entry.getKey()));
         item.setQuantity(entry.getValue());
         itemList.add(item);
         });
         cart.setItems(itemList);

         //处理运费和商品优惠
         itemList.stream().forEach(item -> {
            //运费为商品总价的10%
            item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.setCouponPrice(BigDecimal.ZERO);
            });

        //计算商品总价
         cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice().setTotalDiscount(
                 cart.getItems().stream().map(Item::getCouponPrice
                                 //应付总价=商品总价+运费总价-总优惠
                                 cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPric
                                         return cart;
         }*/

      return null;
    }

    public static void main(String[] args) {

        List<String>list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


        list.stream().forEach(s -> {
            if (s == "1"){
                System.out.println(s);
            }
        });

        IntStream.range(1,20).forEach(i-> System.out.print(i+","));//返回一个1-19的数字流
        System.out.println();
        IntStream.rangeClosed(1,20).forEach(i-> System.out.print(i+","));//返回的一个1-20的数字流


    }


}