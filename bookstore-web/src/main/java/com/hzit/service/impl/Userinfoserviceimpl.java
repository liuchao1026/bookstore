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
    public int delet(Integer userid) {
        try {
            int num = userinfoMapper.deleteUserinfoByUserid(userid);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

        @Override
        public int update (Userinfo userinfo){
            return 0;
        }

        @Override
        public List<Userinfo> findbyid (int userid){
            Map m=new HashMap();
            m.put("userid",userid);
            List<Userinfo> list=userinfoMapper.searchUserinfoByParams(m);
            return list;
        }

    @Override
    public List<Userinfo> find(@RequestParam("username") String username, @RequestParam("userpwd") String userpwd) {
      Map m=new HashMap();
        m.put("username",username);
        m.put("userpwd",userpwd);
        List<Userinfo> list=userinfoMapper.searchUserinfoByParams(m);
        return list;
    }


}
