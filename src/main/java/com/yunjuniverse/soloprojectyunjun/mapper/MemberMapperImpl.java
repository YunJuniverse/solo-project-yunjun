package com.yunjuniverse.soloprojectyunjun.mapper;

import com.yunjuniverse.soloprojectyunjun.entity.Member;
import com.yunjuniverse.soloprojectyunjun.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberMapperImpl implements MemberMapper {
    @Override
    public MemberDto.response memberToMemberResponse(Member member) {
        if (member == null) {
            return null;
        }
        long memberId = 0L;
        String name = null;
        String sex = null;
        String companyName = null;
        String companyType = null;
        String companyLocation = null;

        if ( member.getMemberId() != null ) {
            memberId = member.getMemberId();
        }
        name = member.getName();
        sex = member.getSex();
        companyName = member.getCompanyName();
        companyType = member.getCompanyType();
        companyLocation = member.getCompanyLocation();

        MemberDto.response response = new MemberDto.response(memberId, name, sex, companyName, companyType, companyLocation);
        return response;
    }

    @Override
    public List<MemberDto.response> membersToMemberResponses(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberDto.response> list = new ArrayList<MemberDto.response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToMemberResponse( member ) );
        }

        return list;
    }

}
