package com.mybatis6.mapper;

import com.mybatis6.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> findUserInfoByUserNameLike(UserInfo userInfo);
    List<UserInfo> findUserInfoByName(UserInfo userInfo);
    int updateUserInfoUsernameAndPassword(UserInfo userInfo);
    UserInfo findUserInfoById(Integer id);
    List<UserInfo> findUserInfoByUserNameWithIf_Trim(UserInfo userInfo);
    int updateUserInfoUsernameAndPassword_Trim(UserInfo userInfo);
    List<UserInfo> findUserInfo_Choose(UserInfo userInfo);
}
