package com.freundebuchag.freund;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.net.URI;
import java.time.LocalDate;

@SpringBootTest
class FreundApplicationTests {

    @Value(value="8080")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private FriendController friendController;
    /*
    @Test
    void contextLoads() throws Exception{
        assertThat(friendController).isNotNull();
    }

    @Test
    public void shouldCreateFirend() throws Exception {
        //Given
        final String baseUrl = "http://localhost:" + port + "/friend";
        URI uri = new URI(baseUrl);
        Friend friend = new Friend(null, "Angelina", "Otto", LocalDate.now(), "Bratkartoffeln", "Rochen", "Spino");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Friend> request = new HttpEntity<>(friend, headers);

        ResponseEntity<FriendRequest> result = this.restTemplate.postForEntity(uri, request, FriendRequest.class);

        assertThat(result.getStatusCodeValue() == 201);
    }
*/
}
