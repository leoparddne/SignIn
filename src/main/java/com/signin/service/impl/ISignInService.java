package com.signin.service.impl;

import com.signin.model.signin;

import java.util.List;

public interface ISignInService {
    List<signin> GetLeastData(String code)throws Exception;
}
