package ir.mci.core.conroller;

import static org.springframework.http.HttpStatus.OK;

import ir.mci.core.model.Form;
import ir.mci.core.model.UserDto;
import ir.mci.core.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/info", consumes = "application/json", produces = "application/json")
public class Controller {

    private final UserServiceImpl userServiceImpl;

    public Controller(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/postloginform")
    public ResponseEntity<String> login(@RequestBody Form form) {
        System.out.println(form);

        String jsonResponse = "{\"message\": \"Login successful\"}"; // http response //
        return ResponseEntity.status(OK).body(jsonResponse);
    }

    @PostMapping("/userinfo")
    public ResponseEntity<UserDto> userInfo(@RequestBody String username) {
        System.out.println("list of all users are: ");
        Optional<UserDto> findedUser=userServiceImpl.list(username);
        if (findedUser.isPresent())
         return ResponseEntity.status(OK).body(findedUser.get());
        else
         return null;
    }
    @PostMapping("/saveuser")
    public ResponseEntity<String> saveUser (@RequestBody UserDto userDto) {
        userServiceImpl.save(userDto);
        System.out.println(userDto.toString());
        String jsonResponse = "{\"message\": \"user added\"}";
        return ResponseEntity.status(OK).body(jsonResponse);

    }
}
