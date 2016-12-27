package com.ssm.service;

import com.ssm.domain.Goods;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
public interface GoodsService {

    boolean updateGoods(int id, Goods goods);

    List<Goods> findAll();

    Goods findById(int id);

    List<Goods> findbyPage(int start, int pageSize);

    Boolean addGoods(Goods goods);

    boolean deleteGoods(int id);
}
