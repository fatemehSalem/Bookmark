package com.demo.bookmarker.domain;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args)  {
        bookmarkRepository.save(new Bookmark(null,"gitHub-link" , "https://github.com/" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"Twitter" , "https://twitter.com/" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"arxiv" , "https://arxiv.org/abs/2201.05222" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"zabox" , "https://www.zabox.net" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"facebook" , "https://www.facebook.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"google" , "https://www.google.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"pinterest" , "https://www.pinterest.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"gitHub-link" , "https://www.tumblr.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"tumblr" , "https://github.com/" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"reddit" , "https://www.reddit.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"stumbleupon" , "https://www.stumbleupon.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"technorati" , "https://www.technorati.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"delicious" , "https://www.delicious.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"newsvine" , "https://www.newsvine.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"scoop" , "https://www.scoop.it" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"diigo" , "https://www.diigo.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"friendfeed" , "https://www.friendfeed.com" , Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"plurk" , "https://www.plurk.com" , Instant.now()));


    }
}
