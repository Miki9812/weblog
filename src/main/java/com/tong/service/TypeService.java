package com.tong.service;

import com.tong.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> getAllType();

    int updateType(Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> getBlogType();//首页右侧展示type对应的博客数量
}
