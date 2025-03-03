package com.javaee.use_ex01;

import com.javaee.ex01.PriceService;

public class BookService {
    public float getNewPrice(float originPrice, float discount){
        return new PriceService().newPrice(originPrice, discount);
    }
}
