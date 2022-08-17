package com.yunjuniverse.soloprojectyunjun.service;


import com.yunjuniverse.soloprojectyunjun.dto.TestDto;
import com.yunjuniverse.soloprojectyunjun.entity.Member;
import com.yunjuniverse.soloprojectyunjun.exception.BusinessLogicException;
import com.yunjuniverse.soloprojectyunjun.exception.ExceptionCode;
import com.yunjuniverse.soloprojectyunjun.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Page<Member> findMemberList(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Member> MemberList = memberRepository.findAll(pageable);
        return MemberList;
    }

    @Transactional(readOnly = true)
    public TestDto test(int page, int size) {return new TestDto(page,size);}

    @Transactional(readOnly = true)
    public List<Member> findMember(int size,int page)
    {List<Member> memberList = memberRepository.test(size,page); return memberList;}

}




