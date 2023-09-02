package com.demo.bookmarker.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//define custom property sources for your tests, which can override or supplement
// the application's property configuration for testing purposes.
@TestPropertySource(properties = {"spring.datasource.url="})
class BookmarkControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @CsvSource({"1,18,2,1,true,false,true,false",
            "2,18,2,2,false,true,false,true"})
    void shouldGetBookmark(int pageNum, int totalElement, int totalPage,
                           int currentPage, boolean isFirst, boolean isLast, boolean hasNext,
                           boolean hasPrevious) throws Exception {
        mvc.perform(get("/api/bookmarks/getAll?page=" + pageNum)).
                andExpect(status().isOk()).andExpect(jsonPath("$.totalElement").value(totalElement)).
                andExpect(jsonPath("$.totalPage").value(totalPage)).
                andExpect(jsonPath("$.currentPage").value(currentPage)).
                andExpect(jsonPath("$.isFirst").value(isFirst)).
                andExpect(jsonPath("$.isLast").value(isLast)).
                andExpect(jsonPath("$.hasNext").value(hasNext)).
                andExpect(jsonPath("$.hasPrevious").value(hasPrevious));
    }

}