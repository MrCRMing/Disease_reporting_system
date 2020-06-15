package JavaEE.controller;

import JavaEE.domain.User;
import JavaEE.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("UserController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    //注册
    @RequestMapping(value="/register",produces = "application/json;charset=UTF-8")
    public @ResponseBody String
    register( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= request.getParameter("username");
        String email_addr=request.getParameter("email_addr");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        User user=new User();
        user.setUsername(username);
        user.setEmail_addr(email_addr);
        user.setPassword(password);
        String code="";
        String msg="";
        //调用service方法
        try{
            userService.register(user,role);
            code="1000";
            msg="注册成功";
        }catch (Exception e){
            e.printStackTrace();
            code="1001";
            msg="注册失败，可能账号已注册过";
            user=null;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("user",user);

        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";

        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    //登录
    @RequestMapping(value="/login",produces = "application/json;charset=UTF-8")
    public @ResponseBody String
    login( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email_addr=request.getParameter("email_addr");
        String password=request.getParameter("password");
        User user=new User();
        //调用service方法
        int state=userService.login(email_addr,password, user);
        String code="";
        String msg="";
        if(state==1){
            //登录成功
            code="1000";
            msg="登录成功";
        }else if(state==2){
            //账号不存在
            code="1001";
            msg="账号不存在";
        }else{
            //密码错误
            code="1002";
            msg="密码错误";
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("user",user);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";

        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
}
