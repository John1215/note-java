package com.github.deer_apple.controller;

import com.github.deer_apple.DAO.UserDAO;
import java.util.List;
import java.util.Map;
import com.github.deer_apple.service.SampleService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Decoder;

/**
 *
 * @author Deer-Apple
 */
@RestController
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private SampleService sv;

    @Autowired
    private UserDAO dao;

    private String img;

    @RequestMapping("/get_list")
    public List<Map<String, Object>> do_getListByUsername(@RequestParam("username") String username) {
        return sv.getListByUsername(username);
    }

    @RequestMapping("/add_user")
    public void do_addUser(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {
        dao.addUsr(username, passwd);
    }

    @RequestMapping("/login")
    public boolean do_login(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {
        return dao.do_login(username, passwd);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String do_post(HttpServletRequest request, HttpServletResponse response) throws IOException {
        img = request.getParameter("img");
//        System.out.println("img len:" + img.length());
//        System.out.println("img=" + img);
        return "success";
    }

    @RequestMapping("/get")
    public String do_getListByUsername() {
        return this.img;
    }

    // @RequestMapping("/get_student")
    // public Map<String, Object> do_getStudentById(@RequestParam("id") String id) {
    //     return sv.getStudentById(id);
    // }

    // @RequestMapping("/add_student")
    // public void do_addStudent(@RequestParam("stu_number") String stu_number, @RequestParam("name") String name, @RequestParam("depart") String depart) {
    //     sv.addStudent(stu_number, name, depart);
    // }

    // @RequestMapping("/remove_student")
    // public void do_removeStudent(@RequestParam("id") String id) {
    //     sv.removeStudent(id);
    // }

    // @RequestMapping("/modify_student")
    // public void do_modifyStudent(@RequestParam("id") String id, @RequestParam("stu_number") String stu_number, @RequestParam("name") String name, @RequestParam("depart") String depart) {
    //     sv.modifyStudent(id, stu_number, name, depart);
    // }
}
