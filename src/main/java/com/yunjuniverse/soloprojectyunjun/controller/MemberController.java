package com.yunjuniverse.soloprojectyunjun.controller;


import com.yunjuniverse.soloprojectyunjun.service.MemberService;
import com.yunjuniverse.soloprojectyunjun.dto.MultiResponseDto;
import com.yunjuniverse.soloprojectyunjun.dto.SingleResponseDto;
import com.yunjuniverse.soloprojectyunjun.entity.Member;
import com.yunjuniverse.soloprojectyunjun.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMemberList(page - 1, size);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.membersToMemberResponses(members),
                        pageMembers),
                HttpStatus.OK);
    }
    /*
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId){
        Member member = memberService.findMember();
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponse(member))
                , HttpStatus.OK);
    }
    */

    @GetMapping("/search")
    public ResponseEntity findMember(@RequestParam(required = false, value = "id") String id,
                                     @RequestParam(required = false, value = "name") String name,
                                     @RequestParam(required = false, value = "sex") String sex,
                                     @RequestParam(required = false, value = "company_name") String company_name,
                                     @RequestParam(required = false, value = "company_type") String company_type,
                                     @RequestParam(required = false, value = "company_location") String company_location,
                                     @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(required = false, value = "size", defaultValue = "10") Integer size)
    {
        List<Member> memberList = memberService.findMember(page, size);
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }

}
