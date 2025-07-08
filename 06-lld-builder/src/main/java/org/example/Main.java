package org.example;

public class Main {
    public static void main(String[] args) {
        Product laptop = Product.builder()
                .name("laptop")
                .description("this is a laptop")
                .price(10_000)
                .ram(32)
                .rating(4)
                .build();
        System.out.println(laptop);
    }
}