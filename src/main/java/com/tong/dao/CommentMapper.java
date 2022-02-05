package com.tong.dao;

import com.tong.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Mapper
@Repository
@Resource
public interface CommentMapper {

    //根据创建时间排序
    List<Comment> listCommentByBlogId(@Param("blogId") Long blogId,@Param("blogParentId") Long blogParentId);

    //添加一个评论
    int saveComment(Comment comment);

    //查询父级对象
    Comment findByParentCommentId(@Param("parentCommentId") Long parentcommentid);
}
