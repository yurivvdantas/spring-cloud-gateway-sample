package com.example.gateway;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/")
@Slf4j
public class GatewayApplication {

	public static void main(String[] args) {
        BlockHound.install();
		SpringApplication.run(GatewayApplication.class, args);
	}

	@GetMapping("hora")
    public Mono<Map<String,LocalDateTime>> getHora(){
        return Mono
                .just(Collections.singletonMap("time", LocalDateTime.now()))
                .doOnSuccess(l -> log.info("Hora atual consultada com sucesso"));
    }

}
