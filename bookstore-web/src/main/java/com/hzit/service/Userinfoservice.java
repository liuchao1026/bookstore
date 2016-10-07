package com.hzit.service;

import com.hzit.dao.entity.Userinfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/6.
 */
public interface Userinfoservice {
    boolean add(Userinfo userinfo);

    int delet(Integer userid);

    int update(Userinfo userinfo);

    List<Userinfo> findbyid(int userid);

    List<Userinfo> find(@RequestParam("username")String username,@RequestParam("userpwd")String userpwd);
}
