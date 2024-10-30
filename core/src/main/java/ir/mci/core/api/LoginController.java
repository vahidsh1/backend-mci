package ir.mci.core.api;

import static org.springframework.http.HttpStatus.OK;

import ir.mci.core.model.Form;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/info", consumes = "application/json", produces = "application/json")
public class LoginController {

    @PostMapping("/postloginform")
    public ResponseEntity<String> login(@RequestBody Form form) {
        System.out.println(form);
        String jsonResponse = "{\"message\": \"Login successful\"}";
        return ResponseEntity.status(OK).body(jsonResponse);
    }
}
