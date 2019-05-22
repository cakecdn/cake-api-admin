package net.cakecdn.api.admin.code.service;

import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.code.entity.RechargeCode;

import java.util.List;

/**
 * @author Okeyja
 * @version 2019/05/20 020 10:28
 */
public interface RechargeCodeService {

    CustomPage<RechargeCode> listCodes(int page, int size);

    List<RechargeCode> generateCode(int number, int days, long trafficBytes);

    void deleteCode(long id);

}
