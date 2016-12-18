/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deer_apple.DAO;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Deer-Apple
 */
@Component
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbc;
    
    public void addUsr(String username, String passwd){
        String sql = "insert into usr(username, passwd) values(?,?)";
        this.jdbc.update(sql, username, passwd);
    }
    
    public Map<String, Object> searchUser(String username){
        String sql = "select passwd from usr where username = ?";
        try{
            return this.jdbc.queryForMap(sql, username);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    
    public boolean do_login(String username, String passwd){
        Map<String, Object> map = this.searchUser(username);
        if(map == null){
            return false;
        }
        return passwd.equals(map.get("passwd"));
    }
}
