package com.zz.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entities.ResultData;
import com.zz.entities.Score;
import com.zz.entities.Student;
import com.zz.entities.view.ScoreView;
import com.zz.mapper.ScoreMapper;
import com.zz.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Resource
    private StudentMapper studentMapper;

    // 创建DecimalFormat对象，指定保留两位小数
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public ResultData add(Score score) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        boolean exists = scoreMapper.exists(wrapper.eq("stu_number", score.getStuNumber()).eq("xueqi", score.getXueqi()));
        if (exists) {
            //该学生的成绩已存在，不能重复添加
            return ResultData.err("该学生的成绩已存在，不能重复添加");
        }
        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id", score.getStuNumber()));
        if (student == null){
            return ResultData.err("该学生不存在");
        }

        score.setStuName(student.getName());
        double scoreCont = Double.parseDouble(score.getScoreDe()) + Double.parseDouble(score.getScoreZhi())
                + Double.parseDouble(score.getScoreTi()) + Double.parseDouble(score.getScoreNeng());
        score.setScoreCount(df.format(scoreCont));
        score.setScoreAvg(df.format(scoreCont / 4.0));
        //添加到数据库
        int insert = scoreMapper.insert(score);
        return insert == 1 ?
                ResultData.ok("ok") :
                ResultData.err("添加失败，请联系管理员");
    }

    public ResultData update(Score score) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_number", score.getStuNumber()).eq("xueqi", score.getXueqi());
        Score one = scoreMapper.selectOne(wrapper);
        if (one == null) {
            return ResultData.err("记录不存在");
        }
        double scoreCont = Double.parseDouble(score.getScoreDe()) + Double.parseDouble(score.getScoreZhi())
                + Double.parseDouble(score.getScoreTi()) + Double.parseDouble(score.getScoreNeng());
        score.setScoreCount(df.format(scoreCont));
        score.setScoreAvg(df.format(scoreCont / 4.0));
        int i = scoreMapper.updateById(score);
        return i == 1 ?
                ResultData.ok("ok") :
                ResultData.err("更新失败，请联系管理员");
    }

    public ResultData delete(Integer id) {
        return scoreMapper.deleteById(id) == 1 ?
                ResultData.ok("ok") :
                ResultData.err("删除失败，请联系管理员");
    }

    public ResultData selectOne(String stuNumber, String xueqi) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        //该学生所有学期的成绩
        List<Score> scoreList = scoreMapper.selectList(wrapper.eq("stu_number", stuNumber).like("xueqi", xueqi));
        LinkedList<ScoreView> views = new LinkedList<>();
        for (Score score : scoreList) {
            ScoreView view = new ScoreView();
            BeanUtil.copyProperties(score, view);
            wrapper.clear();
            //查找同一学期，同一学院的所有学生成绩
            wrapper.eq("college_name", score.getCollegeName()).eq("xueqi", score.getXueqi());
            List<Score> scores = scoreMapper.selectList(wrapper);
            //设置排名
            view.setRanking(getRanking(scores, score) + "");
            views.add(view);
        }

        return new ResultData(0, "查询成功", views, 0, views.size(), 0);

    }

    /**
     * 计算排名
     *
     * @param list        数据源
     * @param targetScore 目标
     * @return
     */
    private int getRanking(List<Score> list, Score targetScore) {
        int ranking = 1;
        for (Score score : list) {
            if (targetScore.getStuNumber().equals(score.getStuNumber())) {
                continue;
            }
            if (Double.parseDouble(score.getScoreCount()) >= Double.parseDouble(targetScore.getScoreCount())) {
                ranking++;
            }
        }
        return ranking;
    }

    public List<Score> queryPage(int page, int limit, String xueqi) {
        return scoreMapper.queryPage((page - 1) * limit, limit, "%" + xueqi + "%");
    }

    public Score countScore(String xueqi) {
        return scoreMapper.countScore("%" + xueqi + "%");
    }

    public ResultData queryScoreById(Integer id) {
        return ResultData.ok(scoreMapper.selectById(id));
    }
}
