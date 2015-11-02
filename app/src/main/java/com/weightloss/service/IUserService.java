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
}
