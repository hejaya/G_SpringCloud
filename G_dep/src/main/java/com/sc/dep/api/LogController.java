package com.sc.dep.api;

import com.sc.common.response.ResponseResult;
import com.sc.dep.pojo.Log;
import com.sc.dep.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:14
 **/
@RestController
@RequestMapping("log")
@Api(value = "日志API",tags = "日志API")
public class LogController {

    @Autowired
    private LogService logService;


    @ApiOperation(value = "查询所有日志", httpMethod = "GET")
    @RequestMapping(value = "logs",method = RequestMethod.GET)
    public ResponseResult getAllLogs(){
        return logService.getAllLogs();
    }

    @ApiOperation(value = "分页查询所有日志", httpMethod = "GET")
    @RequestMapping(value = "logs/{page}/{rows}",method = RequestMethod.GET)
    public ResponseResult getAllLogsByPage(@ApiParam(required = true, value = "页码") @PathVariable(name = "page") Integer page,
                                           @ApiParam(required = true, value = "每页数量") @PathVariable(name = "rows") Integer rows){
        return logService.getAllLogsByPage(page,rows);
    }


    @ApiOperation(value = "新增日志", httpMethod = "POST")
    @RequestMapping(value = "logs",method = RequestMethod.POST)
    public ResponseResult addLog(@ApiParam(required = true, value = "日志json数据") @RequestBody Log log){
        return logService.addLogs(log);
    }

/*    @ApiOperation(value = "删除日志", httpMethod = "DELETE")
    @RequestMapping(value = "Loga/{id}",method = RequestMethod.DELETE)
    public ResponseResult delDep(@ApiParam(required = true, value = "日志id") @PathVariable(name = "id") String id){
        return Logaervice.delLoga(id);
    }

    @ApiOperation(value = "更新日志", httpMethod = "PUT")
    @RequestMapping(value = "Loga/{id}",method = RequestMethod.PUT)
    public ResponseResult updateDep(@ApiParam(required = true, value = "日志id") @PathVariable(name = "id") String id){
        return Logaervice.updateLoga(id);
    }*/
}
