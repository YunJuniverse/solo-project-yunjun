package com.yunjuniverse.soloprojectyunjun;

import com.google.gson.Gson;
import com.yunjuniverse.soloprojectyunjun.dto.MemberDto;
import com.yunjuniverse.soloprojectyunjun.entity.Member;
import com.yunjuniverse.soloprojectyunjun.mapper.MemberMapper;
import com.yunjuniverse.soloprojectyunjun.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class ControllerTest1 {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberService memberService;
    @Autowired
    private MemberMapper mapper;

    @Autowired
    private Gson gson;

    private ResultActions postResultActions;
    private MvcResult postResult;

    URI createURI(String url) {return UriComponentsBuilder.newInstance().path(url).build().toUri();}
    URI createURI(String url, long resourceId) {return UriComponentsBuilder.newInstance().path(url).buildAndExpand(resourceId).toUri();}
    String MEMBER_URL = "/v1/members";
    URI getURI() {
        return createURI(MEMBER_URL);
    }
    URI getURI(long memberId) {return createURI(MEMBER_URL + "/{memberId}", memberId);}

    @Test
    public void getMemberTest() throws Exception {
        //given
        long memberId = 1L;
        Member member1 = new Member(1L, "김코딩", "s4goodbye!", "M", "프로젝트스테이츠", "005", "001");
        Member member2 = new Member(2L, "유코딩", "s4goodbye!", "F", "프로젝트스테이츠", "005", "001");
        Member member3 = new Member(3L, "황코딩", "s4goodbye!", "M", "NHN", "001", "013");


        URI uri = getURI(memberId);
        //when
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON));

        //then
        if(memberId == 1L){
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(member1.getName()))
                .andExpect(jsonPath("$.data.sex").value(member1.getSex()))
                .andExpect(jsonPath("$.data.companyName").value(member1.getCompanyName()))
                .andExpect(jsonPath("$.data.companyType").value(member1.getCompanyType()))
                .andExpect(jsonPath("$.data.companyLocation").value(member1.getCompanyLocation()));
        }
        if(memberId == 2L){
            actions.andExpect(status().isOk())
                    .andExpect(jsonPath("$.data.name").value(member2.getName()))
                    .andExpect(jsonPath("$.data.sex").value(member2.getSex()))
                    .andExpect(jsonPath("$.data.companyName").value(member2.getCompanyName()))
                    .andExpect(jsonPath("$.data.companyType").value(member2.getCompanyType()))
                    .andExpect(jsonPath("$.data.companyLocation").value(member2.getCompanyLocation()));
        }
        if(memberId == 3L){
            actions.andExpect(status().isOk())
                    .andExpect(jsonPath("$.data.name").value(member3.getName()))
                    .andExpect(jsonPath("$.data.sex").value(member3.getSex()))
                    .andExpect(jsonPath("$.data.companyName").value(member3.getCompanyName()))
                    .andExpect(jsonPath("$.data.companyType").value(member3.getCompanyType()))
                    .andExpect(jsonPath("$.data.companyLocation").value(member3.getCompanyLocation()));
        }
    }

    @Test
    public void getMembersTest() {
        //given
        Member member1 = new Member(1L, "김코딩", "s4goodbye!", "M", "프로젝트스테이츠", "005", "001");
        Member member2 = new Member(2L, "유코딩", "s4goodbye!", "F", "프로젝트스테이츠", "005", "001");
        Member member3 = new Member(3L, "황코딩", "s4goodbye!", "M", "NHN", "001", "013");

        //when

        //then
    }
}
