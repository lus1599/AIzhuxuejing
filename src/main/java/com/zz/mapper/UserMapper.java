package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.entities.Student;
import com.zz.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryUserByName(String username);
    int insertUserInfo(@Param("user") User user);

    User queryUserByUserId(@Param("userId") String userId);

    List<User> queryUserByPage(int page, int limit, @Param("username") String username);

    User countsUser(@Param("username") String username);
}
