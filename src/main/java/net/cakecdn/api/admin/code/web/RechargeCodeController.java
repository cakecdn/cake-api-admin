package net.cakecdn.api.admin.code.web;

import net.cakecdn.api.admin.all.domain.dto.AjaxResult;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.code.entity.RechargeCode;
import net.cakecdn.api.admin.code.service.RechargeCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharge-code")
public class RechargeCodeController {

    private final RechargeCodeService rechargeCodeService;

    @Autowired
    public RechargeCodeController(RechargeCodeService rechargeCodeService) {
        this.rechargeCodeService = rechargeCodeService;
    }

    @GetMapping
    public AjaxResult list(
            @RequestParam int page,
            @RequestParam int size
    ) {
        CustomPage<RechargeCode> rechargeCodeCustomPage = rechargeCodeService.listCodes(page, size);
        return AjaxResult.success(rechargeCodeCustomPage);
    }

    @PostMapping
    public AjaxResult generate(
            @RequestParam int number,
            @RequestParam int days,
            @RequestParam long trafficBytes
    ) {
        rechargeCodeService.generateCode(number, days, trafficBytes);
        return AjaxResult.success();
    }

    @PostMapping("/batch-remove")
    public AjaxResult batchRemove(@RequestBody List<Long> ids) {
        for (long id : ids) {
            rechargeCodeService.deleteCode(id);
        }
        return AjaxResult.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResult generate(
            @PathVariable long id
    ) {
        rechargeCodeService.deleteCode(id);
        return AjaxResult.success();
    }
}
