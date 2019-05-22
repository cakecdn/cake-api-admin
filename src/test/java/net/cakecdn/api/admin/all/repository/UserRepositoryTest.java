package net.cakecdn.api.admin.all.repository;

import net.cakecdn.api.admin.CakeApiAdminApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends CakeApiAdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findById() {
        System.out.println(userRepository.findById(1l));
    }
}