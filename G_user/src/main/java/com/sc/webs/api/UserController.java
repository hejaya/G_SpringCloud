package com.sc.webs.api;

import com.sc.common.response.ResponseResult;
import com.sc.webs.client.DepClient;
import com.sc.webs.pojo.User;
import com.sc.webs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:11
 **/

@Controller
@RequestMapping("user")
@Api(value = "用户API",tags = "用户API")
public class UserController {

    @Autowired
    private DepClient depClient;

    @Autowired
    private UserService userService;


    /**
     * 远程调用
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "远程调用查询所有部门", httpMethod = "GET")
    @RequestMapping(value = "deps",method = RequestMethod.GET)
    public ResponseResult getAllDeps(){
        return depClient.getAllDeps();
    }

    @ResponseBody
    @ApiOperation(value = "查询所有用户", httpMethod = "GET")
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public ResponseResult getAllUsers(){
        return userService.getAllUsers();
    }

    @ResponseBody
    @ApiOperation(value = "分页查询所有用户", httpMethod = "GET")
    @RequestMapping(value = "users/{page}/{rows}",method = RequestMethod.GET)
    public ResponseResult getAllUsersByPage(@ApiParam(required = true, value = "页码") @PathVariable(name = "page") Integer page,
                                           @ApiParam(required = true, value = "每页数量") @PathVariable(name = "rows") Integer rows){
        return userService.getAllUsersByPage(page,rows);
    }

    @ApiOperation(value = "跳转到用户用户", httpMethod = "GET")
    @RequestMapping(value = "usersList",method = RequestMethod.GET)
    public String toAllUsers(Model model){
        ResponseResult allUsers = userService.getAllUsers();
        List<User> users = (List<User>) allUsers.getData();
        model.addAttribute("users",users);
        return "user";
    }

}
