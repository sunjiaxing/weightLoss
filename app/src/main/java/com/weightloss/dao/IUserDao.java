package com.weightloss.dao;

import com.weightloss.dao.entity.User;

/**
 * Created by admin on 2015/11/2.
 */
public interface IUserDao {
    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据Id获取用户信息
     * @param userId
     * @return
     */
    User getUserById(int userId);

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User getUserByName(String userName);
}
