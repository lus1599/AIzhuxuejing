package com.zz.service;

import com.zz.entities.ResultData;
import com.zz.entities.User;
import com.zz.entities.Zxj;
import com.zz.mapper.UserMapper;
import com.zz.mapper.ZxjMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ZxjServicce {
    @Resource
    private ZxjMapper zxjMapper;
    @Resource
    private UserMapper userMapper;

    public List<Zxj> queryZxjByPage(int page, int limit, String name,String userId) {
        return zxjMapper.queryZxjByPage((page - 1) * limit, limit, "%" + name + "%", userId);
    }

    public Zxj countUser(String name, String userId) {
        return zxjMapper.count("%" + name + "%", userId);
    }

    public ResultData add(Zxj zxj, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        User user = userMapper.queryUserByName(username);
        zxj.setWorkId(user.getUserId());
        return zxjMapper.insert(zxj) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("添加失败");
    }

    public ResultData updateZxj(Zxj zxj) {
        return zxjMapper.updateById(zxj) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("修改失败");
    }

    public ResultData queryZxjById(Integer id) {
        return ResultData.ok(zxjMapper.selectById(id));
    }

    public ResultData deleteZxjById(Integer id) {
        return zxjMapper.deleteById(id)== 1 ?
                ResultData.ok("ok") :
                ResultData.err("删除失败");
    }
}
