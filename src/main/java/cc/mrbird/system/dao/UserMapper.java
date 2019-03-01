package cc.mrbird.system.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.system.domain.User;
import cc.mrbird.system.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    User findByName(String userName);

    List<User> findUserWithDept(User user);

    List<UserWithRole> findUserWithRole(Long userId);

    User findUserProfile(User user);
}