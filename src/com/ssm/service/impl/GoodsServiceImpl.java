package com.ssm.service.impl;

import com.ssm.dao.GoodsDao;
import com.ssm.domain.Goods;
import com.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/24.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public boolean updateGoods(int id, Goods goods) {
        goods.setId(id);
        return goodsDao.updateByPrimaryKeySelective(goods)==1?true:false;
    }

    @Override
    public List<Goods> findAll() {
        return goodsDao.selectAll();
    }

    @Override
    public Goods findById(int id) {
        return goodsDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> findbyPage(int start, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("page",start);
        map.put("rows",pageSize);
        return goodsDao.findGoodsByPage(map);
    }

    @Override
    public Boolean addGoods(Goods goods) {
        return goodsDao.insert(goods)==1?true:false;
    }

    @Override
    public boolean deleteGoods(int id) {
        return goodsDao.deleteByPrimaryKey(id)==1?true:false;
    }
}
