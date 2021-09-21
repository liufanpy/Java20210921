package com.tanhua.server.controller;

import com.tanhua.domain.vo.PageResult;
import com.tanhua.domain.vo.RecommendUserQueryParam;
import com.tanhua.domain.vo.TodayBestVo;
import com.tanhua.server.service.TodayBestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 佳人控制层
 */
@RestController
@RequestMapping("/tanhua")
public class TodayBestController {
    @Autowired
    private TodayBestService todayBestService;

    /**
     * 今日佳人
     */
    @RequestMapping(value = "/todayBest",method = RequestMethod.GET)
    public ResponseEntity todayBest(){
        TodayBestVo todayBestVo =todayBestService.todayBest();
        return ResponseEntity.ok(todayBestVo);
    }

    /**
     * 推荐用户列表（推荐佳人列表）
     */
    @RequestMapping(value = "/recommendation",method = RequestMethod.GET)
    public ResponseEntity recommendation(RecommendUserQueryParam recommendUserQueryParam){
        PageResult<TodayBestVo> pageResult =todayBestService.recommendation(recommendUserQueryParam);
        return ResponseEntity.ok(pageResult);
    }
}
