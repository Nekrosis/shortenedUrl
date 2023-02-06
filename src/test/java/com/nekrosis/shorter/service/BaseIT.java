package com.nekrosis.shorter.service;

import com.nekrosis.shorter.model.Url;
import com.nekrosis.shorter.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BaseIT {
    @Autowired
    UrlService service;
    @MockBean
    UrlRepository repository;

}
