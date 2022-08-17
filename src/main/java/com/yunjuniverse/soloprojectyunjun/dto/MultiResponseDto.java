package com.yunjuniverse.soloprojectyunjun.dto;

import com.yunjuniverse.soloprojectyunjun.entity.PageInfo;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {

    private List<T> members;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> members, Page page) {
        this.members = members;
        this.pageInfo = new PageInfo(page.getNumber() + 1,
                page.getSize(), (int) page.getTotalElements(), page.getTotalPages());
    }
}