package com.sc.dep.service;

import com.sc.common.response.ResponseResult;
import com.sc.common.utils.IdWorker;
import com.sc.dep.dao.DepRepository;
import com.sc.dep.pojo.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/30 7:57
 **/
@Transactional
@Service
public class DepService {

    @Autowired
    private DepRepository depRepository;

    @Autowired
    private IdWorker idWorker;

    public ResponseResult getAllDeps(){
        return new ResponseResult(true,200,"查询成功",depRepository.getAllBySQL());
    }

    public ResponseResult addDeps(Dep dep) {
        dep.setId(String.valueOf(idWorker.nextId()));
        depRepository.save(dep);
        return new ResponseResult(true,200,"添加成功",null);
    }

    public ResponseResult delDeps(String id) {
        depRepository.deleteById(id);
        return new ResponseResult(true,200,"删除成功",null);
    }

    public ResponseResult updateDeps(String id) {
        depRepository.updateDepBySQL(id);
        return new ResponseResult(true,200,"修改成功",null);
    }

    public ResponseResult getAllDepsByPage(Integer page, Integer rows) {
        Pageable pageable = PageRequest.of(page-1, rows);
        Page<Dep> all = depRepository.findAll(pageable);
        return new ResponseResult(true,200,"查询成功",
                new com.sc.common.utils.Page<Dep>(all.getContent(),page,
                        all.getTotalPages(),all.getTotalElements()));
    }
}
