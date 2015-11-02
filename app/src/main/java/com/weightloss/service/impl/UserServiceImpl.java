package com.weightloss.service.impl;

import android.content.Context;

import com.weightloss.service.IUserService;
import com.weightloss.ui.vo.UserVO;

import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public class UserServiceImpl extends BaseService implements IUserService {

    UserServiceImpl(Context context) {
        super(context);
    }

    @Override
    public List<UserVO> getUserList() {

        return null;
    }
}
