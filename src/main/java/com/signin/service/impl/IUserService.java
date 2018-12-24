package com.signin.service.impl;

import com.signin.UserType;
import org.springframework.stereotype.Service;

/**
 * @author:ives time:12/23/2018
 * des:
 */

public interface IUserService {
    String Login(String username, String password, UserType type);
}
