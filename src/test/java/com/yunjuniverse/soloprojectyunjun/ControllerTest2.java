package com.yunjuniverse.soloprojectyunjun;

import com.yunjuniverse.soloprojectyunjun.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@SpringBootTest
public class ControllerTest2 {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MemberService memberService;

    @Test
    public void findAllTestWithPageSize() throws Exception {
        // given
        String page = "1";
        String size = "3";
        ResultActions actions =
                mockMvc.perform(get("/v1/")
                        .param("page", page)
                        .param("size", size)
                );
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("members.[1].name").value("김코딩2"))
                .andDo(
                        document("getAllMembersWithPagination", requestParameters(
                                        parameterWithName("page").description("the page number"),
                                        parameterWithName("size").description("content size per page")

                                ),
                                responseFields(        // (9-6)
                                        List.of(
                                                fieldWithPath("members.[]").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                                fieldWithPath("members.[].id").type(JsonFieldType.NUMBER).description("생성번호"),
                                                fieldWithPath("members.[].name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("members.[].password").type(JsonFieldType.STRING).description("비번"),
                                                fieldWithPath("members.[].sex").type(JsonFieldType.STRING).description("성별"),
                                                fieldWithPath("members.[].company_name").type(JsonFieldType.STRING).description("회사 이름"),
                                                fieldWithPath("members.[].company_type").type(JsonFieldType.NUMBER).description("회사 타입 번호"),
                                                fieldWithPath("members.[].company_location").type(JsonFieldType.NUMBER).description("회사 위치 번호"),
                                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 데이터"),
                                                fieldWithPath("pageInfo.sort").type(JsonFieldType.OBJECT).description("정렬정보"),
                                                fieldWithPath("pageInfo.sort.sorted").type(JsonFieldType.BOOLEAN).description("정렬 유무"),
                                                fieldWithPath("pageInfo.sort.unsorted").type(JsonFieldType.BOOLEAN).description("정렬 반전"),
                                                fieldWithPath("pageInfo.sort.empty").type(JsonFieldType.BOOLEAN).description("정렬 empty"),
                                                fieldWithPath("pageInfo.pageNumber").type(JsonFieldType.NUMBER).description("페이지 번호"),
                                                fieldWithPath("pageInfo.pageSize").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
                                                fieldWithPath("pageInfo.offset").type(JsonFieldType.NUMBER).description("페이지 오프셋"),
                                                fieldWithPath("pageInfo.unpaged").type(JsonFieldType.BOOLEAN).description("페이지 옵션"),
                                                fieldWithPath("pageInfo.paged").type(JsonFieldType.BOOLEAN).description("페이지 옵션")


                                        )
                                )

//
                        ));


    }

    @Test
    public void findMemberTestWithPageSize() throws Exception {
        // given
        // (6) 테스트 데이터
        String page = "0";
        String size = "20";

        String name = "김코딩";
        String sex = "m";

        ResultActions actions =
                mockMvc.perform(get("/v1/find")
                        .param("page", page)
                        .param("size", size)
                        .param("name", name)
                        .param("sex", sex)
                );
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("김코딩"))
                .andExpect(jsonPath("sex").value("m"))
                .andDo(
                        document("findMemberTestWithPageSize", requestParameters(
                                        parameterWithName("page").description("page number"),
                                        parameterWithName("size").description("page size"),
                                        parameterWithName("name").description("name"),
                                        parameterWithName("sex").description("sex")

                                ),
                                responseFields(        // (9-6)
                                        List.of(
                                                fieldWithPath("").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("번호"),
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("sex").type(JsonFieldType.STRING).description("성별"),
                                                fieldWithPath("company_name").type(JsonFieldType.STRING).description("회사 이름"),
                                                fieldWithPath("company_type").type(JsonFieldType.NUMBER).description("회사 타입 번호"),
                                                fieldWithPath("company_location").type(JsonFieldType.NUMBER).description("회사 위치 번호")
                                        )
                                )
                        )
                );

//

    }
}