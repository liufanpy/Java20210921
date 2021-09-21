package com.tanhua.server.controller;

import com.tanhua.domain.vo.UserInfoVo;
import com.tanhua.server.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制层
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 查询用户信息
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity queryUserInfo(Long userID, Long huanxinID){
        UserInfoVo userInfoVo = userInfoService.queryUserInfo(userID,huanxinID);
        return ResponseEntity.ok(userInfoVo);
    }


    /**
     * 更新用户信息
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserInfo(@RequestBody UserInfoVo userInfoVo){
        userInfoService.updateUserInfo(userInfoVo);
        return ResponseEntity.ok(null);
    }
}
