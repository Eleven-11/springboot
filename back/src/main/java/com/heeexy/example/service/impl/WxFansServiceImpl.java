package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.WxFansDao;
import com.heeexy.example.service.WxFansService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：良优
 * @ Date       ：Created in 11:36 2019/6/17
 * @ Description：用户粉丝关注接口实现层
 * @ Version: 1.0
 */
@Service
public class WxFansServiceImpl implements WxFansService {
    @Autowired
    private WxFansDao wxFansDao;
    /*查找关注用户列表*/
    @Override
    public JSONObject getListByUserId(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = wxFansDao.countByUserId(jsonObject);
        List<JSONObject> list = wxFansDao.getListByUserId(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
    /*对用户关注状态的修改*/
    @Override
    public JSONObject updateFansByUserId(JSONObject jsonObject) {
         wxFansDao.updateFansByUserId(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject addByFans(JSONObject jsonObject) {
        //     添加粉丝关注用户
        wxFansDao.addByFans(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject getUserFans(JSONObject jsonObject) {
        //查看是否有关注用户
        JSONObject user = wxFansDao.getUserFans(jsonObject);
        return user;
    }

    @Override
    public JSONObject getListFans(JSONObject jsonObject) {
        //后台关注用户展示
        CommonUtil.fillPageParam(jsonObject);
        int count = wxFansDao.countUserFans(jsonObject);
        List<JSONObject> list = wxFansDao.getListFans(jsonObject);
        System.out.println(list);
        return CommonUtil.successPage(jsonObject, list, count);

    }


}