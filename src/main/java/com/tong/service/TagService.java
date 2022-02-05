package com.tong.service;

import com.tong.pojo.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    List<Tag> getTagByString(String text);

    Tag listTag(String ids);

    int updateTag(Tag tag);

    int deleteTag(Long id);

    List<Tag> getBlogTag();//首页展示博客标签
}
