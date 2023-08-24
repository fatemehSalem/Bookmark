package com.demo.bookmarker.domain;


import lombok.RequiredArgsConstructor;
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

    @Transactional(readOnly = true)
    public BookmarkDTO getAll(Integer page){
        int pageNo = page < 1 ? 0: page - 1;
        Pageable pageable = PageRequest.of(pageNo , 10 , Sort.Direction.ASC , "createAt");
        return new BookmarkDTO(bookmarkRepository.findAll(pageable));
    }
}
