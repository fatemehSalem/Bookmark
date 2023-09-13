package com.demo.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("select new com.demo.bookmarker.domain.BookmarkDTO(b.id, b.title, b.url,b.createAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

    @Query("""
        select new com.demo.bookmarker.domain.BookmarkDTO(b.id, b.title, b.url,b.createAt) from Bookmark b where lower(b.title) like lower(concat('%', :query, '%'))
    """)
    Page<BookmarkDTO> searchBookmarks(String query , Pageable pageable);

    /*Page<BookmarkVM> findByTitleContainsOrderByIdTitle(String query , Pageable pageable);*/

}
