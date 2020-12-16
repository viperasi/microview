package com.xu81.microview.api.goods.service;

import com.xu81.microview.api.goods.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> listAll();

    Goods getById(int id);

    int add(Goods goods);
}
