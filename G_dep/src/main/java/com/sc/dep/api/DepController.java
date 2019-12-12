package com.sc.dep.api;

import com.sc.common.response.ResponseResult;
import com.sc.dep.pojo.Dep;
import com.sc.dep.service.DepService;
import com.sc.dep.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:14
 **/
@RefreshScope//刷新注解
@RestController
@RequestMapping("dep")
@Api(value = "部门API",tags = "部门API")
public class DepController {

    @Autowired
    private DepService depService;

    @Autowired
    private MenuService menuService;

    @Value("${guan}")
    private String testString;


    @ApiOperation(value = "查询所有部门", httpMethod = "GET")
    @RequestMapping(value = "deps",method = RequestMethod.GET)
    public ResponseResult getAllDeps(){
        return depService.getAllDeps();
    }

    @ApiOperation(value = "查询所有菜单", httpMethod = "GET")
    @RequestMapping(value = "menus",method = RequestMethod.GET)
    public ResponseResult getAllMenus(){
        return menuService.getAllMenus(0);
    }

    @ApiOperation(value = "分页查询所有部门", httpMethod = "GET")
    @RequestMapping(value = "deps/{page}/{rows}",method = RequestMethod.GET)
    public ResponseResult getAllDepsByPage(@ApiParam(required = true, value = "页码") @PathVariable(name = "page") Integer page,
                                           @ApiParam(required = true, value = "每页数量") @PathVariable(name = "rows") Integer rows){
        System.out.println("刷新数据 = " + testString);
        return depService.getAllDepsByPage(page,rows);
    }


    @ApiOperation(value = "新增部门", httpMethod = "POST")
    @RequestMapping(value = "deps",method = RequestMethod.POST)
    public ResponseResult addDep(@ApiParam(required = true, value = "部门json数据") @RequestBody Dep dep){
        return depService.addDeps(dep);
    }

    @ApiOperation(value = "删除部门", httpMethod = "DELETE")
    @RequestMapping(value = "deps/{id}",method = RequestMethod.DELETE)
    public ResponseResult delDep(@ApiParam(required = true, value = "部门id") @PathVariable(name = "id") String id){
        return depService.delDeps(id);
    }

    @ApiOperation(value = "更新部门", httpMethod = "PUT")
    @RequestMapping(value = "deps/{id}",method = RequestMethod.PUT)
    public ResponseResult updateDep(@ApiParam(required = true, value = "部门id") @PathVariable(name = "id") String id){
        return depService.updateDeps(id);
    }
}
