package com.bookshop.service;

import com.bookshop.beans.OrderInfo;
import com.bookshop.beans.Userinfo;
import com.bookshop.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;


    //根据用户的id查询用户的订单
    @Override
    public List<OrderInfo> queryOrderByUserId(Userinfo userinfo) {
        return orderMapper.queryOrderByUserId(userinfo);
    }

    //根据用户id增加订单数量
    @Override
    public void addOrderQuantity(OrderInfo orderInfo) {
        orderMapper.addOrderQuantity(orderInfo);
    }
    //根据用户id减少订单数量
    @Override
    public void reduceOrderQuantity(OrderInfo orderInfo) {
        orderMapper.reduceOrderQuantity(orderInfo);
    }
    //根据用户id删除订单
    @Override
    public void deleteOrder(OrderInfo orderInfo) {
        orderMapper.deleteOrder(orderInfo);
    }
    //添加到购物车
    @Override
    public void addToCart(OrderInfo orderInfo) {
        orderMapper.addToCart(orderInfo);
    }
    //根据订单id查询订单
    @Override
    public OrderInfo queryOrderByOrderid(int orderid) {
        return orderMapper.queryOrderByOrderid(orderid);
    }

    //更新订单的状态
    @Override
    public void updateOrderState(OrderInfo orderInfo) {
        orderMapper.updateOrderState(orderInfo);
    }

    //立刻购买
    @Override
    public void buyNow(OrderInfo orderInfo) {
        orderMapper.buyNow(orderInfo);
    }
}
