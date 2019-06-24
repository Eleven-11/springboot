package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.WxBrowserDao;
import com.heeexy.example.service.WxBrowserService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：良优
 * @ Date       ：Created in 13:49 2019/6/18
 * @ Description：
 * @ Version:1.0
 */
@Service
public class WxBrowserServiceImpl implements WxBrowserService {
    @Autowired
    private WxBrowserDao wxBrowserDao;
    //添加浏览记录
    @Override
    public JSONObject addBrowsePost(JSONObject jsonObject) {
         wxBrowserDao.addBrowsePost(jsonObject);
        return CommonUtil.successJson();
    }
//查找该用户是否存在该帖子的浏览记录
    @Override
    public JSONObject getBrowsePostByPostId(JSONObject jsonObject) {
        JSONObject browsePostByPostId = wxBrowserDao.getBrowsePostByPostId(jsonObject);
        return browsePostByPostId;
    }
//修改用户浏览记录
    @Override
    public JSONObject updateBrowse(JSONObject jsonObject) {
        wxBrowserDao.updateBrowse(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject getBrowseList(JSONObject jsonObject) {
        //后台浏览记录数据
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = wxBrowserDao.getBrowseList(jsonObject);
        int count = wxBrowserDao.countBrowse(jsonObject);

        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject getBrowseByUser(JSONObject jsonObject) {
        //前台用户浏览记录
        List<JSONObject> browseByUser = wxBrowserDao.getBrowseByUser(jsonObject);

       return CommonUtil.successPage(browseByUser);
    }
}