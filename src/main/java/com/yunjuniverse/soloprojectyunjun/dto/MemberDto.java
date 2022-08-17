package com.yunjuniverse.soloprojectyunjun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {

    @AllArgsConstructor
    @Getter
    public static class response {
        private long memberId;
        private String name;
        private String sex;
        private String companyName;
        private String companyType;
        private String companyLocation;
    }
}
