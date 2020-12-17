package com.xu81.microview.api.goods.service.impl;

import com.xu81.microview.api.goods.entity.Goods;
import com.xu81.microview.api.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private static final Logger LOG = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Override
    public List<Goods> listAll() {
        List<Goods> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goods g = new Goods();
            g.setId(i);
            g.setName("goods-" + i);
            lists.add(g);
        }
        return lists;
    }

    @Override
    public Goods getById(int id) {
        Goods g = new Goods();
        g.setId(id);
        g.setName("goods-" + id);
        return g;
    }

    @Override
    public int add(Goods goods) {
        return 1;
    }
}
