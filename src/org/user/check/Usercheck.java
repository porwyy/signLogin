package org.user.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.user.entity.User;
import org.user.util.DBUtil;

public class Usercheck {
	//用户登录函数，这里通过姓名查找
    public User findUserByName(String userName){
        String sql="select * from user_info where name=?";
        Connection conn= DBUtil.getConnection();
        ResultSet rs= null; //用来存放返回的数据
        User user = new User();
        try {
        	//定义查询方法
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs=ps.executeQuery();
            //将查询到的结果放入user对象，然后返回
            if(rs.next()){
                user.setUid(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPass(rs.getString(3));
            }
        } catch (SQLException e) { //处理异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConn(conn, null, rs); //关闭链接
        }
        return user;
        
    }
    //添加用户的方法，用上面相同，不再解释
    public int addUser(User user){
        String sql = "insert into user_info values(?,?,?)";
        Connection conn= DBUtil.getConnection();
        ResultSet rs= null;
        int i=0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUid());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getUserPass());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, null, rs);
        }
    return i;
    }
    public static void main(String[] args) {
        
    }
}