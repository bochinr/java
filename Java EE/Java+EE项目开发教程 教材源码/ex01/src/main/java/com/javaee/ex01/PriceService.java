package com.javaee.ex01;

public class PriceService {
    public float newPrice(float originPrice, float discount){
        return originPrice * discount; // 计算折扣价
    }
}
