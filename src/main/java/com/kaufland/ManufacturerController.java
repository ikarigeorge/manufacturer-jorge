package com.kaufland;

/**
 * Created by java2303 on 24.11.16.
 */
import com.kaufland.dto.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// cross origin to allow calls from another site
@CrossOrigin(origins = "*")
@RestController()
public class ManufacturerController {

    private static Logger LOGGER = Logger.getLogger(ManufacturerController.class);

    @PostMapping("/api/order")
    public ResponseEntity sendOrder(@RequestBody ProductDTO productDTO) {
        LOGGER.info("Get Order!" + productDTO.toString());
        return ResponseEntity.ok().build();
    }
}
