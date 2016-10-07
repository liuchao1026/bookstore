package com.hzit.service.impl;

import com.hzit.dao.entity.Book;
import com.hzit.dao.mapper.BookMapper;
import com.hzit.service.Booksservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/7.
 */
@Service
public class BooksImpl implements Booksservice {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> selectbypage(String page) {
        return null;
    }
}
