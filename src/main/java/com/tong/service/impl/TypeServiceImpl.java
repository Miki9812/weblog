package com.tong.service.impl;

import com.tong.dao.TypeMapper;
import com.tong.pojo.Type;
import com.tong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {



    @Autowired
    private final TypeMapper typeMapper;

    @Autowired
    public TypeServiceImpl(TypeMapper typeMapper){
        this.typeMapper =typeMapper;
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }
    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeMapper.listType(pageable);
    }
    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> getBlogType() {
        return typeMapper.getBlogType();
    }
}
