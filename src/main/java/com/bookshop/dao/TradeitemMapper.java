package com.bookshop.dao;


import com.bookshop.beans.Tradeitem;
import com.bookshop.beans.TradeitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeitemMapper {
    long countByExample(TradeitemExample example);

    int deleteByExample(TradeitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Tradeitem record);

    int insertSelective(Tradeitem record);

    List<Tradeitem> selectByExample(TradeitemExample example);

    Tradeitem selectByPrimaryKey(Integer itemid);

    List<Tradeitem> selectByExampleWithBookAndTrade(TradeitemExample example);

    Tradeitem selectByPrimaryKeyWithBookAndTrade(Integer itemid);

    int updateByExampleSelective(@Param("record") Tradeitem record, @Param("example") TradeitemExample example);

    int updateByExample(@Param("record") Tradeitem record, @Param("example") TradeitemExample example);

    int updateByPrimaryKeySelective(Tradeitem record);

    int updateByPrimaryKey(Tradeitem record);
}