package com.tong.dao;

import com.tong.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
@Resource
public interface TagMapper {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);

    List<Tag> getBlogTag();//首页展示博客标签

}
