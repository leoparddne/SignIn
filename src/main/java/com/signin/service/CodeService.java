package com.signin.service;

import com.signin.mapper.codeMapper;
import com.signin.mapper.signinMapper;
import com.signin.model.codeExample;
import com.signin.model.signin;
import com.signin.service.impl.ICodeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: time:12/26/2018
 * des:
 */
@Service
public class CodeService implements ICodeService {
    private SqlSession session;
    @Override
    public boolean SaveCode(int userid,String code) {
        try {
            //利用sqlSessionFactory打开与数据库的会话
            session = com.signin.MyBatisUtil.getSqlSession();
            codeMapper codeMapper = session.getMapper(codeMapper.class);
            com.signin.model.code data = new com.signin.model.code();
            data.setCode(code);
            data.setUserid(userid);
            int result = codeMapper.insert(data);
            session.commit();
            if (result > 0)
                return true;
            else
                return false;
        }
        catch (Exception e)
        {

        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean SignIn(int userid, String code) {
        try {
            //利用sqlSessionFactory打开与数据库的会话
            session = com.signin.MyBatisUtil.getSqlSession();
            //判断是否存在此code
            codeMapper codeMapp=session.getMapper(codeMapper.class);
            codeExample ex=new codeExample();
            ex.createCriteria().andCodeEqualTo(code);
            if(codeMapp.countByExample(ex)==0)
            {
                return  false;
            }
            signinMapper signin = session.getMapper(signinMapper.class);
            com.signin.model.signin data = new com.signin.model.signin();
            data.setCode(code);
            data.setUserid(userid);
            data.setTime(new Date());
            int result = signin.insert(data);
            session.commit();
            if (result > 0)
                return true;
            else
                return false;
        }
        catch (Exception e)
        {

        }
        finally {
            session.close();
        }
        return false;
    }
}
