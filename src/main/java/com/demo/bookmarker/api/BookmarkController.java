package com.demo.bookmarker.api;

import com.demo.bookmarker.domain.BookmarkDTO;
import com.demo.bookmarker.domain.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping("/getAll")
    public BookmarkDTO getAll(@RequestParam(name="page" , defaultValue = "1") Integer page){
        return bookmarkService.getAll(page);
    }
}
