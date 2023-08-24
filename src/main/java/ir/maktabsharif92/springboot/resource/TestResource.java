package ir.maktabsharif92.springboot.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestResource {

    @GetMapping
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok().build();
    }
}
