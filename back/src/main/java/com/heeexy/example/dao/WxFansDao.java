package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：良优
 * @ Date       ：Created in 11:33 2019/6/17
 * @ Description：用户粉丝关注接口Dao层
 * @ Version: 1.0
 */
public interface WxFansDao {


     /**
          * @methodsName: getListByUserId
          * @description: 查找关注用户列表
          * @param:  JSONObject
          * @return: List<JSONObject>
          */
     List<JSONObject> getListByUserId(JSONObject jsonObject);

      /**
           * @methodsName: countByUserId
           * @description: 计算关注用户数
           * @param: JSONObject
           * @return: List<JSONObject>
           */
     List<JSONObject> countByUserId(JSONObject jsonObject);

      /**
           * @methodsName: updateFansByUserId
           * @description: 对用户关注状态的取消
           * @param:  JSONObject
           * @return: int
           */
     int updateFansByUserId(JSONObject jsonObject);
      /**
           * @methodsName: updateFansStateByUserId
           * @description: 重新修改关注状态
           * @param:  JSONObject
           * @return: int
           */
     int updateFansStateByUserId(JSONObject jsonObject);

      /**
           * @methodsName: addByFans
           * @description: 添加粉丝关注用户
           * @param:  JSONObject
           * @return: int
           */
     int addByFans(JSONObject jsonObject);

      /**
           * @methodsName: getUserFans
           * @description: 查找是否之前有关注用户信息
           * @param:  JSONObject
           * @return: JSONObject
           */
     JSONObject getUserFans(JSONObject jsonObject);

      /**
           * @methodsName: getListFans
           * @description: 查找所有用户粉丝关注表
           * @param:  JSONObject
           * @return:  List<JSONObject>
           */
     List<JSONObject> getListFans(JSONObject jsonObject);
      /**
           * @methodsName: countUserFans
           * @description: 计算所有用户关注信息数
           * @param:  JSONObject
           * @return: int
           */
     int countUserFans(JSONObject jsonObject);
      /**
           * @methodsName: getListMoreFansById
           * @description: 查找用户未关注的用户集合
           * @param:  JSONObject
           * @return:  List<JSONObject>
           */
     List<JSONObject> getListMoreFansById(JSONObject jsonObject);
      /**
           * @methodsName: addMoreFans
           * @description: 批量添加关注
           * @param:  Map
           * @return: int
           */
     int addMoreFans(Map map);

    /**
     * @methodsName: myFans
     * @description: 我的关注
     * @param:  JSONObject
     * @return:  List<JSONObject>
     */
     List<JSONObject> myFans(JSONObject jsonObject);
}
