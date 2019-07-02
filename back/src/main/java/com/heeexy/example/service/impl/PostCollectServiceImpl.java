package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.PostCollectDao;
import com.heeexy.example.service.PostCategorieService;
import com.heeexy.example.service.PostCollectService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chenqiangyong
 * @description:帖子收藏的/增删改查的实现
 * @date: 2019/6/20 10:52
 * @vevsion 1.0
 */

@Service
public class PostCollectServiceImpl implements PostCollectService {

//   ************************ 后台************************

    @Autowired
    private PostCollectDao postCollectDao;


    /**
     * 添加帖子收藏
     * @param jsonObject postId(帖子id),userId(用户id)
     * @return
     */
    @Override
    public JSONObject addPostCollect(JSONObject jsonObject) {
        int exist = postCollectDao.queryExistPostCollectPU( jsonObject );
        if( exist > 0 ){
            int dexist = postCollectDao.queryExistPostCollectDisplay( jsonObject );
            if( dexist == 1 ){
                postCollectDao.updatePostCollectDisplay( jsonObject );
                return  CommonUtil.successJson();
            }else if( dexist == 0 ){
                postCollectDao.updatePostCollectDisplayTwo( jsonObject );
                return  CommonUtil.successJson();
            }
        }
        postCollectDao.addPostCollect( jsonObject );
        return CommonUtil.successJson();
    }

    /**
     * 修改帖子收藏状态值
     * @param jsonObject  postCollectId(收藏id),display(状态值)
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    @Override
    public JSONObject updatePostCollectDisplay(JSONObject jsonObject) {
        postCollectDao.updatePostCollectDisplay( jsonObject );
        return  CommonUtil.successJson();
    }

//    /**
//     * 修改帖子收藏
//     */
//    @Override
//    public JSONObject updatePostCollect(JSONObject jsonObject) {
//        postCollectDao.updatePostCollect( jsonObject );
//        return CommonUtil.successJson();
//    }
    /**
     * 查询所有的帖子收藏
     * 在添加/修改帖子收藏的时候要使用此方法
     * @return
     */
    @Override
    public JSONObject getAllPostCollect() {
        List<JSONObject> roles = postCollectDao.getAllPostCollect();
        return CommonUtil.successJson(roles);
    }
    /**
     * 查询帖子收藏列表
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject listPostCollect(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = postCollectDao.countPostCollect( jsonObject );
        List<JSONObject> list = postCollectDao.listPostCollect( jsonObject );
        return CommonUtil.successPage( jsonObject,list,count );
    }


    //   ************************ 小程序前台************************

    /**
     * 根据用户查询的收藏帖子
     * @param jsonObject  userId(用户id)
     * @return
     */
    @Override
    public JSONObject getAllPostCollectByUserId(JSONObject jsonObject) {
        List<JSONObject> roles = postCollectDao.getAllPostCollectByUserId(jsonObject);
        for (JSONObject role : roles) {
            Object postId = role.get("postId");
            List<JSONObject> allCommentByPostId = postCollectDao.getAllCommentByPostId(postId);
            List<JSONObject> allPostImgByPostId = postCollectDao.getAllPostImgByPostId(postId);
            for (JSONObject object : allCommentByPostId) {
                Object commentId = object.get( "commentId" );
                List<JSONObject> allCommentByToCommentId = postCollectDao.getAllCommentByToCommentId( commentId );
                object.put( "Comments",allCommentByToCommentId);
            }
            role.put( "Comment",allCommentByPostId);
            role.put( "img",allPostImgByPostId);
        }
        return CommonUtil.successJson(roles);
    }
    /**
     * 修改帖子收藏状态值
     * @param jsonObject  postId(帖子id),userId(用户id)
     * @return
     */
    @Override
    public JSONObject updatePostCollectDisplays(JSONObject jsonObject) {
        int presence = postCollectDao.queryExistPostCollectPostId( jsonObject );
        int presences = postCollectDao.queryExistPostCollectUserId( jsonObject );
        if(presence==1){
            if(presences==1){
                int exist = postCollectDao.queryExistPostCollectPU( jsonObject );
                if (exist!=0){
                    int exists = postCollectDao.queryExistPostCollectDisplay( jsonObject );
                    if (exists==0){
                        postCollectDao.updatePostCollectDisplayTwo( jsonObject );
                    }else if(exists==1){
                        postCollectDao.updatePostCollectDisplay( jsonObject );
                    }
                }else {
                    postCollectDao.addPostCollect( jsonObject );
                }
            }
        }
        return CommonUtil.successJson();
    }


}
