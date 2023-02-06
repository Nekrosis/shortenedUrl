package com.nekrosis.shorter.repository;

import com.nekrosis.shorter.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "select long_url from url where short_url=?1", nativeQuery = true)
    String findByShortUrl(String id);
}
