package com.sc.dep.service;

import com.sc.common.response.ResponseResult;
import com.sc.dep.dao.LogRespository;
import com.sc.dep.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/2 13:03
 **/
@Service
public class LogService {
    @Autowired
    private LogRespository logRespository;

    public ResponseResult getAllLogs() {
        return new ResponseResult(true,200,"查询成功",logRespository.findAll());
    }

    public ResponseResult getAllLogsByPage(Integer page, Integer rows) {
        Pageable pageable = PageRequest.of(page-1, rows);
        Page<Log> all = logRespository.findAll(pageable);
        return new ResponseResult(true,200,"查询成功",
                new com.sc.common.utils.Page<Log>(all.getContent(),page,
                        all.getTotalPages(),all.getTotalElements()));
    }

    public ResponseResult addLogs(Log log) {
        logRespository.save(log);
        return new ResponseResult(true,200,"添加成功",null);
    }
}
