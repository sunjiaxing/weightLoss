package com.weightloss.service.impl;

import android.content.Context;

import com.weightloss.common.Utils;
import com.weightloss.dao.IUserDao;
import com.weightloss.dao.entity.User;
import com.weightloss.dao.impl.UserDaoImpl;
import com.weightloss.service.IUserService;
import com.weightloss.ui.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public class UserServiceImpl extends BaseService implements IUserService {

    private final IUserDao userDao;

    public UserServiceImpl(Context context) {
        super(context);
        userDao = new UserDaoImpl(context);
    }

    @Override
    public List<UserVO> getUserList() {
        List<UserVO> showList = null;
        List<User> dbData = userDao.getUserList();
        if (!Utils.isEmpty(dbData)) {
            showList = new ArrayList<>();
            UserVO vo = null;
            for (User user : dbData) {
                vo = new UserVO();
                vo.setUserId(user.getUserId());
                vo.setUserName(user.getUserName());
                showList.add(vo);
            }
        }
        return showList;
    }

    @Override
    public void initUserInfo(String name, float height, float weight, float fatRate, int sex) {
        User user = new User();
        // TODO 数据验证 先跳过
        user.setUserName(name);
        user.setHeight(height);
        user.setWeight(weight);
        user.setSex(sex);
        user.setFatRate(fatRate);
        userDao.updateUser(user);
    }
}
