package com.signin.service;

import com.signin.UserType;
import com.signin.mapper.userMapper;
import com.signin.model.user;
import com.signin.model.userExample;
import com.signin.service.impl.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ives time:12/23/2018
 * des:
 */
@Service
public class UserService implements IUserService {
    private SqlSession session;
    @Override
    public String Login(String username, String password, UserType type) {
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = me.gacl.util.MyBatisUtil.getSqlSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        userExample ex = new userExample();
        ex.createCriteria().andStateEqualTo(1);
        List<user> list=userMapper.selectByExample(ex);
        String f="";
        for (user i :
                list) {
            f=f+i.getId().toString();
            System.out.println(i.getId());
        }
        sqlSession.close();
        return f;
    }
}
