package com.xu81.microview.web.goods;

import com.xu81.microview.api.goods.entity.Goods;
import com.xu81.microview.api.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * class description :
 * 统一登录 controller
 *
 * @author IceExtinguish
 * @version 0.0.1
 * @since 2020/11/13
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/list")
    public List<Goods> goods() {
        return goodsService.listAll();
    }

    @GetMapping(value = "/get/{id}")
    public Goods goods(@PathVariable int id) {
        return goodsService.getById(id);
    }

    @PostMapping(value = "/add")
    public Goods add(@RequestBody Goods goods) {
        int i = goodsService.add(goods);
        if (i > 0) {
            return goods;
        }
        return null;
    }
}
