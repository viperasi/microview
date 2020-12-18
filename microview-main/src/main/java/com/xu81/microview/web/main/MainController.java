package com.xu81.microview.web.main;

import com.xu81.microview.web.main.dto.MicroView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public List<MicroView> mview() {
        List<MicroView> mvlist = new ArrayList<>();
        MicroView user_mv = new MicroView();
        user_mv.setEntry("//localhost:8092");
        user_mv.setName("user");
        user_mv.setContainer("#appContainer");
        user_mv.setActiveRule("/user");
        user_mv.setTitle("用户管理");
        user_mv.setIcon("fas fa-fw fa-users");
        mvlist.add(user_mv);
        MicroView goods_mv = new MicroView();
        goods_mv.setEntry("//localhost:8091");
        goods_mv.setName("goods");
        goods_mv.setContainer("#appContainer");
        goods_mv.setActiveRule("/goods");
        goods_mv.setTitle("物品管理");
        goods_mv.setIcon("fas fa-fw fa-layer-group");
        mvlist.add(goods_mv);
        return mvlist;
    }
}
