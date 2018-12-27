package com.signin.service;

import com.signin.mapper.codeMapper;
import com.signin.mapper.signinMapper;
import com.signin.model.codeExample;
import com.signin.model.signin;
import com.signin.model.signinExample;
import com.signin.service.impl.ISignInService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.ws.ServiceMode;
import java.util.Date;
import java.util.List;
@Service
public class SignInService implements ISignInService {
    private SqlSession session;
    @Override
    public List<signin> GetLeastData(String code) throws Exception {
        try {
            //利用sqlSessionFactory打开与数据库的会话
            session = com.signin.MyBatisUtil.getSqlSession();
            //获取最后一条code记录
           signinMapper signinMap=session.getMapper(signinMapper.class);
            signinExample ex=new signinExample();
            ex.createCriteria().andCodeEqualTo(code);
            List<signin> data =signinMap.selectByExample(ex);
            if(data.size()>0)
                return  data;
        }
        catch (Exception e)
        {

        }
        finally {
            session.close();
        }
        throw new Exception("err");
    }
}
