package com.bookshop.controller;


import com.bookshop.beans.Book;
import com.bookshop.beans.Msg;
import com.bookshop.beans.Userinfo;
import com.bookshop.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Administrator on 2019/5/2.
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    /*分页查询书籍*/
    @RequestMapping("/getbook")
    /*ResponseBody是springMVC用来将对象数据转换成json字符串的，以便浏览器用js解析json字符串，想要可用需要加载json的jar包*/
    @ResponseBody
    public Msg getBook(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
          /*第pn页显示6条信息*/
        PageHelper.startPage(pn, 6);
        List<Book> books = bookService.getAll();
        /*pageInfo封装books的信息，分页框显示1~5的数*/
        PageInfo page = new PageInfo(books, 5);
        return Msg.success().add("pageInfo", page);
    }

    /*根据条件查询贸易项目内容*/
    @RequestMapping(value = "/getBookById/{id}")
    @ResponseBody
    public Msg getBookById(@PathVariable("id")Integer id){
        Book book=bookService.selectBook(id);
        return Msg.success().add("selectBook",book);
    }
    /*@RequestMapping("/getbook")
    public String getBook(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        /*//*第pn页显示6条信息*//**//*
        PageHelper.startPage(pn, 6);
        List<Book> books = bookService.getAll();
        /*//*pageInfo封装books的信息，分页框显示1~5的数*//**//*
        PageInfo page = new PageInfo(books, 5);
        /*//*将page加载到model中使其能将数据带回页面*//**//*
        model.addAttribute("pageInfo", page);
        return "list";


    }*/



    //夏卓贤
     @RequestMapping("/toHomePage")
    public String toHomePage(@RequestParam(value = "pn", defaultValue = "1",required = false) Integer pn, Model model, HttpServletRequest request) {
        /*第pn页显示6条信息*/
        PageHelper.startPage(pn, 20);
        List<Book> books = bookService.getAll();
        /*pageInfo封装books的信息，分页框显示1~5的数*/
        PageInfo page = new PageInfo(books, 5);
        /*将page加载到model中使其能将数据带回页面*/
        model.addAttribute("pageInfo", page);
        return "homePage";
    }

    @RequestMapping("/toPersonalCenter")
    public String toPersonalCenter(@RequestParam(value = "pn", defaultValue = "1",required = false) Integer pn, Model model) {
        /*第pn页显示6条信息*/
        PageHelper.startPage(pn, 20);
        List<Book> books = bookService.getAll();
        /*pageInfo封装books的信息，分页框显示1~5的数*/
        PageInfo page = new PageInfo(books, 5);
        /*将page加载到model中使其能将数据带回页面*/
        model.addAttribute("pageInfo", page);
        return "personalCenter";
    }

    @RequestMapping("/toLogin")
    private String toLogin(){
         return "login";
    }

    @RequestMapping("/toRegister")
    private String toRegister(){
        return "register";
    }

    @RequestMapping("/text")
    @ResponseBody
    private String text(){
         return "text";
    }

    @RequestMapping("/logout")
    private String logout(HttpServletRequest request){
         HttpSession session=request.getSession();
         session.removeAttribute("user");
         return "redirect:/toHomePage";
    }

}
