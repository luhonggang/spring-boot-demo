package com.shanlin.controller;

import com.shanlin.model.Swagger2User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 访问http://localhost:8080/swagger-ui.html
 * Created by hezuchao on 2017/6/9.
 */
@RestController
@Api(description = "用户")
public class Swagger2UserController {
    static Map<String,Swagger2User> userMap = Collections.synchronizedMap(new HashMap<String, Swagger2User>());

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/getUserList" , method = RequestMethod.GET)
    public List<Swagger2User> getUserList(){
        List<Swagger2User> userList = new ArrayList<Swagger2User>(userMap.values());
        return userList;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public String addUser(@RequestBody Swagger2User user) {
        userMap.put(user.getId().toString(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
    public Swagger2User getById(@PathVariable String id) {
        return userMap.get(id);
    }


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/updateById/{id}", method=RequestMethod.PUT)
    public String updateById(@PathVariable String id, @RequestBody Swagger2User user) {
        Swagger2User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id, u);
        return "success";
    }


    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/deleteById/{id}", method=RequestMethod.DELETE)
    public String deleteById(@PathVariable String id) {
        userMap.remove(id);
        return "success";
    }
}
