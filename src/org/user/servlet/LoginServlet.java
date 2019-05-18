package org.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.check.Usercheck;
import org.user.entity.User;
import org.user.service.LoginService;
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取请求信息
        String userName = request.getParameter("name");
        String userPass = request.getParameter("pass");
        
        LoginService service = new LoginService();
        boolean flag = service.checkUser(userName, userPass);
        String msg = flag?"success":"error";
        response.setContentType("charset=utf-8");
        
        //定义一个返回的对象result
        String result = "";
        if(msg=="success"){
        	result = "{result:true}";
        }
        else{
            System.out.println("登录失败，密码错误");
            result = "{result:false}";
        }
        //将result写入并返回给客户端
        response.getWriter().print(result);
    }

}