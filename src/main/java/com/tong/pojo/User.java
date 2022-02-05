package com.tong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String username;
    private String email;
    private Integer type;
    private Date createTime;
    private Date updateTime;
    private String password;
    private String avatar;

    private List<Blog> blogs = new ArrayList<>();


}
