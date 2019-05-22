package net.cakecdn.api.admin.code.service;

import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.code.entity.RechargeCode;
import net.cakecdn.api.admin.code.repository.RechargeCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RechargeCodeServiceImpl implements RechargeCodeService {

    private final RechargeCodeRepository rechargeCodeRepository;

    @Autowired
    public RechargeCodeServiceImpl(RechargeCodeRepository rechargeCodeRepository) {
        this.rechargeCodeRepository = rechargeCodeRepository;
    }

    @Override
    public CustomPage<RechargeCode> listCodes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RechargeCode> rechargeCodePage = rechargeCodeRepository.findAll(pageable);
        return CustomPage.build(rechargeCodePage).withPage(page);
    }

    @Override
    public List<RechargeCode> generateCode(int number, int days, long trafficBytes) {
        List<RechargeCode> rechargeCodeList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            RechargeCode rechargeCode = new RechargeCode(days);
            rechargeCode.setTrafficBytes(trafficBytes);
            rechargeCodeList.add(rechargeCode);
        }
        rechargeCodeRepository.saveAll(rechargeCodeList);
        return null;
    }

    @Override
    public void deleteCode(long id) {
        rechargeCodeRepository.deleteById(id);
    }
}
