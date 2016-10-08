package com.hzit.service.impl;

import com.hzit.dao.entity.Userinfo;
import com.hzit.dao.mapper.UserinfoMapper;
import com.hzit.service.Userinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/6.
 */
@Service
public class Userinfoserviceimpl implements Userinfoservice {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public boolean add(Userinfo userinfo) {
        boolean bo = userinfoMapper.insertUserinfo(userinfo);
        if (bo == true)
            return true;
        else {
            return false;
        }
    }



    @Override
    public Userinfo findone( String username,  String userpwd) {
        Userinfo userinfo=userinfoMapper.findone(username,userpwd);
        return userinfo;
    }



}
