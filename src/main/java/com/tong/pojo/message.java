package com.tong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class message {

    //用户ID
    private Integer id;
    //用户名称
    private String name;
    //用户邮箱
    private String email;
    //内容
    private String content;
    //用户头像
    private String avator;
    //评论时间
    private Date create_time;
    //父留言ID
    private Integer parent_message_id;
    //本人留言
    private Integer admin_message;

}
