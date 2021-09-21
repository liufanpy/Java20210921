package com.tanhua.server.controller;

import com.tanhua.domain.db.User;
import com.tanhua.domain.vo.MomentVo;
import com.tanhua.domain.vo.PageResult;
import com.tanhua.domain.vo.PublishVo;
import com.tanhua.server.service.MovementsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 圈子控制层
 */
@RestController
@RequestMapping("/movements")
@Slf4j //日志注解
public class MovementsController {

    @Autowired
    private MovementsService movementsService;

    /**
     * 发布动态
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity savePublish(PublishVo publishVo, MultipartFile[] imageContent) {
        movementsService.savePublish(publishVo,imageContent);
        return ResponseEntity.ok(null);
    }


    /**
     * 好友动态
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity queryPublishByTimeLine(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pagesize) {
        PageResult<MomentVo> pageResult = movementsService.queryPublishByTimeLine(page,pagesize);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 推荐动态
     */
    @RequestMapping(value = "/recommend",method = RequestMethod.GET)
    public ResponseEntity queryPublishByReQuanzi(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pagesize) {
        PageResult<MomentVo> pageResult = movementsService.queryPublishByReQuanzi(page,pagesize);
        return ResponseEntity.ok(pageResult);
    }

}
