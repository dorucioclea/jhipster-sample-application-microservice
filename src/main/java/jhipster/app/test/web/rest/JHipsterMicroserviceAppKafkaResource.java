package jhipster.app.test.web.rest;

import jhipster.app.test.service.JHipsterMicroserviceAppKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/j-hipster-microservice-app-kafka")
public class JHipsterMicroserviceAppKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JHipsterMicroserviceAppKafkaResource.class);

    private JHipsterMicroserviceAppKafkaProducer kafkaProducer;

    public JHipsterMicroserviceAppKafkaResource(JHipsterMicroserviceAppKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
