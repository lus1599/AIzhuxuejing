package com.zz.controller;

import com.zz.entities.ResultData;
import com.zz.entities.Score;
import com.zz.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @RequestMapping("/page")
    public ResultData queryUserByPage(int page, int limit,
                                      @RequestParam(value = "xueqi", defaultValue = "") String xueqi) {
        List<Score> scores = scoreService.queryPage(page, limit, xueqi);
        Score score = scoreService.countScore(xueqi);
        return new ResultData(0, "查询成功", scores, page, score.getCounts(), limit);
    }

    /**
     * 辅导员添加
     * @param score
     * @return
     */
    @RequestMapping("/add_by_tea")
    public ResultData add(@RequestBody Score score){
        return scoreService.add(score);
    }

    @RequestMapping("/query_score_by_id")
    public ResultData queryScoreById(Integer id){
        return scoreService.queryScoreById(id);
    }

    @RequestMapping("/update")
    public ResultData update(@RequestBody Score score){
        return scoreService.update(score);
    }

    @RequestMapping("/del/{id}")
    public ResultData delete(@PathVariable Integer id){
        return scoreService.delete(id);
    }

    @RequestMapping("/one")
    public ResultData one(HttpServletRequest request, @RequestParam(value = "xueqi", defaultValue = "")String xueqi){
        //学号
        String stuNumber = (String) request.getSession().getAttribute("userId");
        return scoreService.selectOne(stuNumber, xueqi);
    }
}
