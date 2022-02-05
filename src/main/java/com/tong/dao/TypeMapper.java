package com.tong.dao;

import com.tong.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
@Resource
public interface TypeMapper {

    int saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> getAllType();

    int updateType(Type type);

    void deleteType(Long id);

    //首页右侧展示type对应的博客数量
    List<Type> getBlogType();

}
