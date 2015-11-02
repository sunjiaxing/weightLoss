package com.weightloss.service;

import com.weightloss.ui.vo.UserVO;

import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public interface IUserService {
    /**
     * 获取用户列表
     * @return
     */
    List<UserVO> getUserList();

    /**
     * 初始化用户信息
     * @param name
     * @param height
     * @param weight
     * @param fatRate
     * @param sex
     */
    void initUserInfo(String name,float height,float weight,float fatRate,int sex);
}
