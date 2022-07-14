package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.AbstractRepository;
import com.guoxi.springdevice.common.AbstractEntity;
import com.guoxi.springdevice.mapper.AbstractMapper;
import com.guoxi.springdevice.service.AbstractService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
public class AbstractController<T extends AbstractEntity, R extends AbstractRepository<T>, M extends AbstractMapper<T>, S extends AbstractService<T, R, M>> {

    @SuppressWarnings("all")
    @Autowired
    private S service;

    @ApiOperation(value = "查询单个")
    @GetMapping(value = "/selectOne")
    public T selectOne(String id) {
        return service.getData(id);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "/saveOrUpdateData")
    public T saveOrUpdateUser(@RequestBody T entity) {
        return service.saveOrUpdateData(entity);
    }
    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/deleteData")
    public Boolean deleteData(@RequestBody T entity) {
        return service.deleteData(entity);
    }

    @ApiOperation(value = "查询全部")
    @PostMapping
    public List<T> listAll() {
        return service.listAllData();
    }
}
