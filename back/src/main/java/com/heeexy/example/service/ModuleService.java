package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: chenqiangyong
 * @description:模块/增删改查
 * @date: 2019/6/18 9:03
 * @vevsion 1.0
 */
public interface ModuleService {

    /**
     * 新增模块
     */
    JSONObject addModule(JSONObject jsonObject);
    /**
     * 新增消息
     */
    JSONObject addMessage(JSONObject jsonObject);


    /**
     * 删除模块
     */
    JSONObject removeModuleDisplay(JSONObject jsonObject);

    /**
     * 修改模块
     */
    JSONObject updateModule(JSONObject jsonObject);

    /**
     * 查询模块列表
     */
    JSONObject listModule(JSONObject jsonObject);


    /**
     * 查询所有的模块
     * 在添加/修改模块的时候要使用此方法
     */
    JSONObject getAllModule();
}
