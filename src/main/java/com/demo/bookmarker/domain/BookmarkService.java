package com.demo.bookmarker.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
   // private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO getAll(Integer page){
        int pageNo = page < 1 ? 0: page - 1;
        Pageable pageable = PageRequest.of(pageNo , 10 , Sort.Direction.ASC , "createAt");
        //Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findAll(pageable).map(bookmarkMapper::toDTO);
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkPage);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query , Integer page){
        int pageNo = page < 1 ? 0: page - 1;
        Pageable pageable = PageRequest.of(pageNo , 10 , Sort.Direction.ASC , "createAt");
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.searchBookmarks(query,pageable);
        /*Page<BookmarkVM> bookmarkPageVM = bookmarkRepository.findByTitleContainsOrderByIdTitle(query,pageable);*/
        return new BookmarksDTO(bookmarkPage);
    }
}
