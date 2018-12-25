package com.signin;

/**
 * @author:ives time:12/24/2018
 * des:
 */
public enum UserType {
    NotUse(0),
    Teaher(10),
    Student(20);
    int key;
    UserType(int i) {
        key=i;
    }
    public int getKey()
    {
        return key;
    }
}
