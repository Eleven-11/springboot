package com.heeexy.example.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : 林成
 * @Description :
 * @Date : 2019-07-04 14:38
 * @Version : 1.0
 **/
@RestController
@RequestMapping("api/commentApi")
public class apiCommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 获取某个用户的评论
     */
    @GetMapping("getCommentByUserId")
    public JSONObject getCommentByUserId(int uid){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", uid);
        jsonObject.put("status", 2);
        return commentService.getComment2(jsonObject);
    }

    /**
     * 获取某个帖子的评论
     */
    @GetMapping("getCommentByPostId")
    public JSONObject getCommentByPostId(int pid){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pid", pid);
        return commentService.getComment2(jsonObject);
    }

    /**
     * 根据id获取一条评论
     */
    @GetMapping("getCommentById/{id}")
    public JSONObject getCommentById(@PathVariable int id){
        return commentService.getCommentById(id);
    }

    /**
     * 添加一条评论
     */
    @PostMapping("addComment")
    public JSONObject addComment(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.get("content"));
        return commentService.addComment(jsonObject);
    }

    /**
     * 删除评论
     */
    @PostMapping("updateComment")
    public JSONObject updateComment(int cid){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cid", cid);
        jsonObject.put("status", -1);
        return commentService.updateComment(jsonObject);
    }
}