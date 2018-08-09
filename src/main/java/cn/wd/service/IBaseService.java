package wd.service;

import wd.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
    int add(T t);
    int deleteByCondition(Serializable id);
    int update(T t);
    T findByCondition(Serializable id);
    List<T> findAll();
    int findrownum();
    List<T> findAllByPage(PageUtil util,Object...obj);
}
