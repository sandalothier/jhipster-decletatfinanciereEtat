package com.fisc.decletatfinanciereetat.web.rest;

import com.fisc.decletatfinanciereetat.service.DecletatfinanciereEtatKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decletatfinanciere-etat-kafka")
public class DecletatfinanciereEtatKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecletatfinanciereEtatKafkaResource.class);

    private DecletatfinanciereEtatKafkaProducer kafkaProducer;

    public DecletatfinanciereEtatKafkaResource(DecletatfinanciereEtatKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
