package net.cakecdn.api.admin.code.service;

import net.cakecdn.api.admin.CakeApiAdminApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RechargeCodeServiceImplTest extends CakeApiAdminApplicationTests {

    @Autowired
    private RechargeCodeService rechargeCodeService;

    @Test
    public void generateCode() {
        rechargeCodeService.generateCode(18, 30, 107374182400L);
    }
}