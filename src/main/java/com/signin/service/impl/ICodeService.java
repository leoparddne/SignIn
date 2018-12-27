package com.signin.service.impl;

/**
 * @author: time:12/26/2018
 * des:
 */
public interface ICodeService {
    boolean SaveCode(int userid,String code);

    boolean SignIn(int userid,String code);
}
