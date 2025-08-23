package com.careerit.jfs.cj.day12;

public class OderManager {

    public static void main(String[] args) {

        Order order = new Order(1, OrderStatus.NEW);
        order.printStatus();

        order.updateStatus(OrderStatus.PROCESSING);
        order.printStatus();

        order.updateStatus(OrderStatus.SHIPPED);
        order.printStatus();

        order.updateStatus(OrderStatus.DELIVERED);
        order.printStatus();

    }
}
