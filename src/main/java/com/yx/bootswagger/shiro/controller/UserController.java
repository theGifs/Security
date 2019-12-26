package com.yx.bootswagger.shiro.controller;

import com.yx.bootswagger.shiro.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author LJH
 *
 */
// @Controller
// @ResponseBody //作用在类上表达类里面的所有方法都以json响应
@RestController // ==Controller+ResponseBody
@RequestMapping("user")
@Api(tags = { "用户管理" },description="用户数据操作")
public class UserController {

//    @Autowired
//    private UserService userService;

        /**
         * 添加用户
         */
        @ApiOperation(value = "新增用户", notes = "新增注册")
        //consumes=MediaType.APPLICATION_JSON_VALUE 标记前台传数据时使用json对象传过来 还要加@RequestBody
        //如果不加consumes应该把数据拼接在url接口后面  参数不能加@RequestBody
        @PostMapping(value= {"addUser"},consumes= MediaType.APPLICATION_JSON_VALUE)
        public Map<String, Object> addUser(@RequestBody User user) {
            Map<String, Object> map = new HashMap<>();
            System.out.println(user);
            map.put("msg", "添加成功");
            map.put("code", 1);
            return map;
        }

        /**
         * 修改用户
         */
        @ApiOperation(value = "修改用户", notes = "修改用户")
        @PostMapping(value= {"updateUser"},consumes=MediaType.APPLICATION_JSON_VALUE)
        public Map<String, Object> updateUser(@RequestBody User user) {
            Map<String, Object> map = new HashMap<>();
            System.out.println(user);
            map.put("msg", "修改成功");
            map.put("code", 1);
            return map;
        }

        /**
         * 删除用户
         */
        @ApiOperation(value = "删除用户", notes = "删除用户")
        @DeleteMapping("deleteUser")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户编号", required = true)
        })
        public Map<String, Object> deleteUser(@RequestParam("id")Integer id) {
            Map<String, Object> map = new HashMap<>();
            System.out.println(id);
            map.put("msg", "删除成功");
            map.put("code", 1);
            return map;
        }

        /**
         * 查询一个用户
         */
        @ApiOperation(value = "根据ID查询用户", notes = "查询用户")
        @GetMapping("queryUserById")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户编号", required = true)
        })
        public User queryUserById(@RequestParam("id")Integer id) {
            return null;
        }

        /**
         * 全查询用户
         */
        @ApiOperation(value = "全查询用户", notes = "查询用户")
        @GetMapping("queryAllUser")
        public List<User> queryAllUser() {

            return null;
        }
}
