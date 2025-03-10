package com.DAO;

import com.BaseClass.User;
import com.Interface.LoginAndRegister;
import com.Interface.UserManage;

import java.util.ArrayList;

/**
 * @Author=Anchor
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */

public class UserDAO extends BaseDAO implements LoginAndRegister, UserManage {

    private User nowUser;//当前登录用户的信息

    @Override
    public int login(String uId, String uPassword) {
        int pms = -1;
        String sql = "select * from usertable where u_id=? and u_password=?";
        Object[] param = {uId, uPassword};
        ArrayList<String> obj = query(sql, param,6);
        nowUser.setuId(obj.get(0));
        nowUser.setuName(obj.get(1));
        nowUser.setuPms(Integer.parseInt(obj.get(2)));
        nowUser.setPassWord(obj.get(3));
        nowUser.setuQuestion(obj.get(4));
        nowUser.setuAnswer(obj.get(5));
        pms = nowUser.getuPms();//这里失败默认返回-1吧
        return pms;//返回权限等级
    }

    @Override
    public boolean register(String uId, String uName, String uPassword,String uQuestion,String uAnswer, int key) {
        String sql1 = "select u_id from usertable where u_id=?";
        Object[] param1 = {uId};
        ArrayList<String> obj = query(sql1, param1, 1);
        if (obj.size()!=0)
            return false;
        String sql2 = "insert into usertable values(?,?,?,?,?,?)";
        int temp=0;
        if(key==114514){
            temp=1;
        }else if(key==5402){
            temp=2;
        }
        Object[] param2={uId,uName,temp,uPassword,uQuestion,uAnswer};
        executeSQL(sql2,param2);
        return true;
    }

    @Override
    public String question(String uId) {
        String sql="select u_question from usertable where u_id=?";
        Object[] param={uId};
        ArrayList<String> obj=query(sql,param,1);
        if(obj.size()==0){
            return null;
        }
        return obj.get(0);
    }

    @Override
    public boolean resetPassword(String uAnswer,String uId,String newPassword) {
        String sql1="select u_answer from usertable where u_id=?";
        Object[] param1={uId};
        ArrayList<String> obj=query(sql1,param1,1);
        if(!obj.get(0).equals(uAnswer)) {
            return false;
        }
        String sql2="update usertable set u_password = ?  where u_id=?";
        Object[] param2={newPassword,uId};
        return executeSQL(sql2, param2) == 1;
    }

    @Override
    public User showUserInformation() {
        return nowUser;
    }

    @Override
    public User[] showNormalManager() {
        String sql = "select * from usertable where u_pms=1";
        ArrayList<String> obj = query(sql, null,6);
        User[] users=new User[obj.size()/6];
        for (int i=0;i<users.length;i=i+6){
            users[i/6]=new User(obj.get(i),obj.get(i+1),Integer.parseInt(obj.get(i+2)),obj.get(i+3),obj.get(i+4),obj.get(i+5));
        }
        return users;
    }

    @Override
    public User[] showNormalUser() {
        String sql = "select * from usertable where u_pms=0";
        ArrayList<String> obj = query(sql, null,6);
        User[] users=new User[obj.size()/6];
        for (int i=0;i<users.length;i=i+6){
            users[i/6]=new User(obj.get(i),obj.get(i+1),Integer.parseInt(obj.get(i+2)),obj.get(i+3),obj.get(i+4),obj.get(i+5));
        }
        return users;
    }

    @Override
    public boolean deleteUser(User user) {
        if(user==null){
            return false;
        }
        if(user.getuPms()>=nowUser.getuPms()) {
            return false;
        }
        String sql="delete from usertable where u_id=?";
        Object[] param = {user.getuId()};
        return executeSQL(sql,param)==1;
    }

    @Override
    public boolean changePermission(User user,int uPms) {
        if(user==null){
            return false;
        }
        if(user.getuPms()>=nowUser.getuPms()) {
            return false;
        }
        user.setuPms(Math.min(uPms, nowUser.getuPms()));
        return true;
    }
}
