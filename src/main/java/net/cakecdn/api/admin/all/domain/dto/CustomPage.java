package net.cakecdn.api.admin.all.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomPage<T> {
    private List<T> list;
    private int pageCount;
    private int page;
    private long total;

    public static <T> CustomPage<T> build(Page<T> page) {
        CustomPage<T> customPage = new CustomPage<>();
        customPage.setList(page.getContent());
        customPage.setTotal(page.getTotalElements());
        customPage.setPageCount(page.getTotalPages());
        return customPage;
    }

    public CustomPage<T> withPage(int page) {
        this.page = page;
        return this;
    }
}
