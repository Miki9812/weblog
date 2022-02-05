package com.tong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//序列化ID
public class Comment{
//    用户ID
    private Long id;
//    用户名称
    private String nickname;
//    用户邮箱
    private String email;
//    博客内容
    private String content;
//    博客头像
    private String avatar;
//    评论时间
    private Date createTime;
//    博客id
    private Long blogId;
//    父评论id
    private Comment parentComment;
//    管理员评论
    private Boolean adminComment;

    private String parentNickname;

    private Blog blog;

    private Long parentCommentId;
}
