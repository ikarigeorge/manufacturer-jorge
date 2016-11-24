package com.kaufland;

/**
 * Created by java2303 on 24.11.16.
 */
import com.kaufland.dto.ManufacturerDTO;
import com.kaufland.dto.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

// cross origin to allow calls from another site
@CrossOrigin(origins = "*")
@Service
public class ManufacturerInitializer {

    private static Logger LOGGER = Logger.getLogger(ManufacturerInitializer.class);

    //from application.properties
    @Value("${registerUrl}")
    String registerUrl;

    @Value("${myUrl}")
    String myUrl;


    static String YOUR_NAME = "Jorge";
    static ProductDTO YOUR_PRODUCT = new ProductDTO(70, 20, 10);

    @Scheduled(fixedRate = 30000)
    @PostConstruct
    public void init() {
        LOGGER.info("Calling to: " + registerUrl);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(registerUrl, new ManufacturerDTO(myUrl, YOUR_NAME, YOUR_PRODUCT), ResponseEntity.class);
        LOGGER.info("ManufacturerInitializer initialized!");
    }
}
