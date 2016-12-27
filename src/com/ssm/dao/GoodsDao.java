package com.ssm.dao;

import com.ssm.domain.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();

    List<Goods> findGoodsByPage(Map<String, Object> map);

}