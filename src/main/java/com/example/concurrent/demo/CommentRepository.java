package com.example.concurrent.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wangyihao
 * @ClassName CommentRepository
 * @date 2020/12/15 16:03
 * @Description
 */
//评论的持久层接口
public interface CommentRepository extends MongoRepository<Comment,String> {
}
