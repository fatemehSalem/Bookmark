package com.demo.bookmarker.config;

import com.demo.bookmarker.domain.BookmarkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookmarkNotFoundException.class)
    ErrorResponse handleBookmarkNotFoundException(BookmarkNotFoundException e) {
        return ErrorResponse
                .builder(e, HttpStatus.NOT_FOUND, e.getMessage())
                .title("Bookmark Not found")
                .type(URI.create("https://api.bookmarks.com/errors/not-found"))
                .property("errorCategory", "Generic")
                .property("timestamp", Instant.now())
                .build();
    }
}
