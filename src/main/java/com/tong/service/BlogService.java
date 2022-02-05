package com.tong.service;

import com.tong.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogService {


    //    增加博客
    int saveBlog(Blog blog);

    //    查询文章管理列表
    List<Blog> getAllBlog();

    //    删除博客
    void deleteBlog(Long id);

    //    编辑博客
    int updateBlog(Blog blog);

    //    查询编辑修改的文章
    Blog getBlogById(Long id);

    //    搜索博客管理列表
    List<Blog> searchByTitleAndType(Blog blog);

    //    主页博客展示
    List<Blog> getIndexBlog();

    //    推荐博客展示
    List<Blog> getAllRecommendBlog();

    //    主页搜索
    List<Blog> getSearchBlog(String query);

    //    主页标题内容
    Blog getDetailedBlog(Long id);

    //    根据类型id获取博客
    List<Blog> getByTypeId(Long typeId);

    //    根据标签tag获取博客
    List<Blog> getByTagId(Long tagId);

    //    归档博客
    Map<String,List<Blog>> archiveBlog();

    //    查询博客条数
    int countBlog();
}
