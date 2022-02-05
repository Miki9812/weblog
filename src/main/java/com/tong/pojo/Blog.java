package com.tong.pojo;

import lombok.*;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    //ID
    private Long id;
    //博客标题
    private String title;
    //博客内容
    private String content;
    //首图地址
    private String firstPicture;
    //标记是否原创
    private String flag;
    //浏览次数
    private Integer views;
    //评论次数
    private Integer commentCount;
    //是否开启赞赏
    private boolean appreciation;
    //是否开启版权
    private boolean shareStatement;
    //是否开启评论
    private boolean commentabled;
    //是否发布
    private boolean published;
    //是否推荐
    private boolean recommend;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;



    //分类
    private Type type;
    //用户
    private User user;
    //分类id
    private Long typeId;
    //用户id
    private Long userId;
    //标签
    private Tag tag;
    //获取多个标签的id
    private String tagIds;
    //博客描述
    private String description;
    //评论集合
    private List<Comment> comments = new ArrayList<>();

    private List<Tag> tags = new ArrayList<>();

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    //将tags集合转换为tagIds字符串形式：“1,2,3”,用于编辑博客时显示博客的tag
    private String tagsToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag: tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }

}
