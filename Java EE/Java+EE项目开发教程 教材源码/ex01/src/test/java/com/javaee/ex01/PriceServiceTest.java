package com.javaee.ex01;

import org.junit.Assert;
import org.junit.Test;

public class PriceServiceTest {
    @Test
    public void newPriceTest(){
        PriceService priceService = new PriceService();
        float price = priceService.newPrice(50.f, 0.9f);
        Assert.assertEquals(45.f,price,0.0f);
        System.out.println("测试完成!");
    }
}
