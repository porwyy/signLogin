package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.check.Usercheck;
import org.user.entity.User;

@WebServlet("/addServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
     
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                //获取请求信息
                int id = Integer.parseInt(request.getParameter("id")) ;//��������ת��
                String userName = request.getParameter("name");
                String userPass = request.getParameter("pass");    
                //写入user对象
                User user = new User();
                user.setUid(id);
                user.setUserName(userName);
                user.setUserPass(userPass);
                
                //调用添加用户方法
                Usercheck dao = new Usercheck();
                int i=dao.addUser(user);
                response.setContentType("charset=utf-8");
                
                //定义返回对象result
                String result  = "";
                if(i==1){
                	result = "{result:true}";
                    
                }else{
                	result = "{result:false}";
                }
                //result写入并返回
                response.getWriter().print(result);
    }

}