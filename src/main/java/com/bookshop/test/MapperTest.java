package com.bookshop.test;

import com.bookshop.beans.Account;
import com.bookshop.beans.Book;
import com.bookshop.beans.Tradeitem;
import com.bookshop.beans.Userinfo;
import com.bookshop.dao.AccountMapper;
import com.bookshop.dao.BookMapper;
import com.bookshop.dao.TradeitemMapper;
import com.bookshop.dao.UserinfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    AccountMapper accountMapper;
@Autowired
UserinfoMapper userinfoMapper;
@Autowired
    BookMapper bookMapper;
@Autowired
    TradeitemMapper tradeitemMapper;

    @Test
    public void testCRUD() {
        System.out.println(tradeitemMapper);

        tradeitemMapper.insertSelective(new Tradeitem(null,1,3,1));
    }
}
