package net.cakecdn.api.admin.user.service;

import net.cakecdn.api.admin.CakeApiAdminApplicationTests;
import net.cakecdn.api.admin.user.domain.UserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

public class UserServiceImplTest extends CakeApiAdminApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void listUser() {
        System.out.println(userService.listUser(0, 2));
    }

    @Test
    public void add() {
        UserDto dto = new UserDto();
        dto.setCellphone("13210000000");
        dto.setEmail("hsmylove@hotmail.com");
        dto.setPassword("123456");
        dto.setCreated(new Date());
        dto.setUsername("huangsong");
        dto.setRoles(new ArrayList<>());
        dto.getRoles().add("ROLE_USER");
        userService.add(dto);
    }

    @Test
    public void delete() {
        userService.delete(9L);
    }
}