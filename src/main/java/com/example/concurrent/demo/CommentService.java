package com.example.concurrent.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wangyihao
 * @ClassName CommentService
 * @date 2020/12/15 16:07
 * @Description
 */
public class CommentService {

    //注入dao
    @Autowired
    private CommentRepository commentRepository;
    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
//如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
//设置一些默认初始值。。。
//调用dao
        commentRepository.save(comment);
    }
    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
//调用dao
        commentRepository.save(comment);
    }
    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
//调用dao
        commentRepository.deleteById(id);
    }
    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
//调用dao
        return commentRepository.findAll();
    }
    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id) {
//调用dao
        return commentRepository.findById(id).get();

    }


}
