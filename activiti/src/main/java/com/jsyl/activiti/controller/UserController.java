package com.jsyl.activiti.controller;

import org.activiti.engine.*;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.engine.repository.Model;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenk
 * @create 2019/12/5 14:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserEntityManager manager;
    @Resource
    private IdentityService identityService;
    @Resource
    private TaskService taskService;
    @Resource
    private RepositoryService repositoryService;

    @GetMapping("/query")
    public User test() {
        System.out.println("-----test-----");
        return manager.findUserById("1");
    }

    @GetMapping("/test2")
    public List<User> test2() {
        return identityService.createUserQuery().list();
    }

    @GetMapping("/test3")
    public boolean test3() {
        return identityService.checkPassword("chenk", "chenk");
    }

    @GetMapping("/test4")
    public List<Model> test4() {
        return repositoryService.createModelQuery().list();
    }
}
