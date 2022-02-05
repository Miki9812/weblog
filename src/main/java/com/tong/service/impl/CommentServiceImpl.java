package com.tong.service.impl;

import com.tong.dao.BlogMapper;
import com.tong.dao.CommentMapper;
import com.tong.pojo.Comment;
import com.tong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BlogMapper blogMapper;


    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //没有父节点默认为-1
        List<Comment> comments = commentMapper.listCommentByBlogId(blogId,Long.parseLong("-1"));
        return comments;
    }

    @Override
    public int saveComment(Comment comment) {
        //获取父id
        Long parentCommentId = comment.getParentComment().getId();
        //没有父级评论默认为-1
        if (parentCommentId != -1){
            comment.setParentComment(commentMapper.findByParentCommentId(comment.getParentCommentId()));
        }else {
            comment.setParentCommentId((long) -1);
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentMapper.saveComment(comment);
    }
}
