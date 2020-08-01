package com.mybatis6.mapper;

import com.mybatis6.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> findUserInfoByUserNameLike(UserInfo userInfo);
}
