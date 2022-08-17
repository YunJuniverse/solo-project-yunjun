package com.yunjuniverse.soloprojectyunjun.mapper;

import com.yunjuniverse.soloprojectyunjun.entity.Member;
import com.yunjuniverse.soloprojectyunjun.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import com.yunjuniverse.soloprojectyunjun.dto.MemberDto.*;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    List<response> membersToMemberResponses(List<Member> members);
    MemberDto.response memberToMemberResponse(Member member);
}
