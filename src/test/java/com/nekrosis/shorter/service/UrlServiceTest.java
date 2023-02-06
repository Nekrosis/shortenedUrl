package com.nekrosis.shorter.service;

import com.nekrosis.shorter.model.Url;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class UrlServiceTest extends BaseIT {
    private final String ORIGINAL = "https://giphy.com/search/broke";

    @Test
    void getLongUrl() {
        service.getLongUrl(service.getShortUrl(ORIGINAL));
        Url url = new Url();
        url.setId(0);
        url.setLongUrl(ORIGINAL);
        url.setShortUrl(service.getShortUrl(ORIGINAL));
        Mockito.when(repository.findByShortUrl(service.getShortUrl(ORIGINAL))).thenReturn(url.getLongUrl());
        verify(repository, times(1)).findByShortUrl(url.getShortUrl());
    }

    @Test
    void generatedShortUrl() {
        service.generatedShortUrl(ORIGINAL);
        Url url = new Url();
        url.setId(0);
        url.setLongUrl(ORIGINAL);
        url.setShortUrl(service.getShortUrl(ORIGINAL));
        Mockito.when(repository.save(url)).thenReturn(url);
        Mockito.verify(repository, times(1)).save(url);
    }
}