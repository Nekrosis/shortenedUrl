package com.nekrosis.shorter;

import com.nekrosis.shorter.controller.UrlController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ShorterApplicationTests {
    @Autowired
    UrlController urlController;

    @Test
    void contextLoads() {
        assertThat(urlController).isNotNull();
    }

}
