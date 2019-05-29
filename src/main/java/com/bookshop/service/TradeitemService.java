package com.bookshop.service;

import com.bookshop.beans.Tradeitem;
import com.bookshop.dao.TradeitemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/3.
 */
@Service
public class TradeitemService {
    @Autowired
    TradeitemMapper tradeitemMapper;

    public List<Tradeitem> getAll() {
        return tradeitemMapper.selectByExampleWithBookAndTrade(null);
    }

    public void addCart(Tradeitem tradeitem) {
        tradeitemMapper.insertSelective(tradeitem);
    }

    public Tradeitem selectCart(Integer itemid) {
        Tradeitem tradeitem=tradeitemMapper.selectByPrimaryKeyWithBookAndTrade(itemid);
        return tradeitem;
    }

    public void update(Tradeitem tradeitem) {
        tradeitemMapper.updateByPrimaryKeySelective(tradeitem);
    }

    public void delete(Integer itemid) {
        tradeitemMapper.deleteByPrimaryKey(itemid);
    }
}
