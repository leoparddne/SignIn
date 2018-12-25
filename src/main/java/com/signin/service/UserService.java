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
        String result="";
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = me.gacl.util.MyBatisUtil.getSqlSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        userExample ex = new userExample();
        ex.createCriteria().andStateNotEqualTo(UserType.NotUse.getKey()).andUsernameEqualTo(username).andPasswordEqualTo(password);
        try {
            if(userMapper.countByExample(ex)>0)
            {
                user u=userMapper.selectByExample(ex).get(0);
                if(u.getType()==UserType.Teaher.getKey())
                {
                    result= "/Teacher/index";
                }
                if(u.getType()==UserType.Student.getKey())
                {
                    result= "/Student/index";
                }
            }else
            {
                return "index";
            }
        }catch (Exception e)
        {
            return e.toString();
        }
        finally {
            sqlSession.close();
        }
        return result;
    }
}
