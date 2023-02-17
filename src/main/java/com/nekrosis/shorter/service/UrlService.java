package com.nekrosis.shorter.service;

import com.google.common.hash.Hashing;
import com.nekrosis.shorter.model.Url;
import com.nekrosis.shorter.repository.UrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class UrlService {
    @Autowired
    UrlRepository repository;


    @Transactional
    public String getLongUrl(String id) {
        return repository.findByShortUrl(id);
    }

    @Transactional
    public Url generatedShortUrl(String url) {

        if (!isValid(url)) {
            throw new RuntimeException("Url is not valid!");
        }
        Url object = new Url();
        object.setLongUrl(url);
        object.setShortUrl(getShortUrl(url));
        log.info(object.getLongUrl());
        log.info(object.getShortUrl());
        return repository.save(object);
    }

    private boolean isValid(String url) {
        return UrlValidator.getInstance().isValid(url);
    }

    public String getShortUrl(String url) {
        return Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();
    }
}
