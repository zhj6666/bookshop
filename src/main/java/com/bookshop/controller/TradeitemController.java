package com.bookshop.controller;

import com.bookshop.beans.Book;
import com.bookshop.beans.Msg;
import com.bookshop.beans.Tradeitem;
import com.bookshop.service.TradeitemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/5/3.
 */
@Controller
public class TradeitemController {


    @Autowired
    TradeitemService tradeitemService;

    /*分页查询贸易项目*/
    @RequestMapping("/getTradeitem")
    /*ResponseBody是springMVC用来将对象数据转换成json字符串的，以便浏览器用js解析json字符串，想要可用需要加载json的jar包*/
    @ResponseBody
    public Msg getTradeitem(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
          /*第pn页显示6条信息*/
        PageHelper.startPage(pn, 6);
        List<Tradeitem> tradeitems = tradeitemService.getAll();
        /*pageInfo封装books的信息，分页框显示1~5的数*/
        PageInfo page = new PageInfo(tradeitems, 5);
        return Msg.success().add("pageInfo", page);
    }

    /*加入购物车，根据获取到的值增加贸易项目*/
    @RequestMapping(value = "/addShoppCart/{bookid}/{quantity}/{tradeid}")
    @ResponseBody
    public Msg addShoppCart(@RequestParam Tradeitem tradeitem) {

        tradeitemService.addCart(tradeitem);
        return Msg.success();
    }

    /*根据条件查询贸易项目内容*/
    @RequestMapping(value = "/getShoppCartById/{itemid}")
    @ResponseBody
    public Msg getShoppCartById(@PathVariable("itemid") Integer itemid) {
        Tradeitem tradeitem = tradeitemService.selectCart(itemid);
        return Msg.success().add("selectCart", tradeitem);
    }

    /*更新贸易项目内容*/
    @RequestMapping(value = "/updateTradeitem/{itemid}")
    @ResponseBody
    public Msg updateTradeitem(Tradeitem tradeitem) {
        tradeitemService.update(tradeitem);
        return Msg.success();

    }

    /*删除贸易项目*/
    @RequestMapping(value = "/deleteTradeitem/{itemid}")
    @ResponseBody
    public Msg deleteTradeitem(@PathVariable("itemid") Integer itemid) {
        tradeitemService.delete(itemid);
        return Msg.success();
    }



    //购物车




}
