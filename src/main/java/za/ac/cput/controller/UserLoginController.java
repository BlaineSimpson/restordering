/* UserLoginController.java
 Implementation the UserLogin controller
 Author: Ali Mohamed (219113505)
 Date: 27 July 2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.service.IUserLoginService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/user")
@Slf4j
public class UserLoginController {

    private final IUserLoginService userService;
    @Autowired
    public UserLoginController(IUserLoginService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public ResponseEntity<UserLogin> save(@Valid @RequestBody UserLogin user){
        log.info("Save Request: {}", user);
        UserLogin insert = userService.save(user);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<UserLogin>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<UserLogin> find = userService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete-user")
    public ResponseEntity<UserLogin> delete(UserLogin user){
        log.info("Delete Request: {}", user);
        this.userService.delete(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<UserLogin>> findAll(){
        List<UserLogin> userLoginList = userService.findAll();
        return ResponseEntity.ok(userLoginList);
    }
}
