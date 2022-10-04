package za.ac.cput.controller;
/* MenuController.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.Menu;
import za.ac.cput.service.IMenuService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("restaurant/menu")
@Slf4j

public class MenuController {
private final IMenuService menuService;
    @Autowired
    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }
@PostMapping("save")
    public ResponseEntity<Menu> save(@Valid @RequestBody Menu menu){
        log.info("save request: {}", menu);
        Menu save = menuService.save(menu);
        return ResponseEntity.ok (save);

    }
    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Menu>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<Menu> find = menuService.findById(id);
        return ResponseEntity.ok(find);
    }
    @DeleteMapping("delete-menu")
    public ResponseEntity<Void> delete(@PathVariable String menu){
        log.info("Delete request: {}",menu);
        this.menuService.deleteById(menu);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}",id);
        this.menuService.deleteById(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping("all")
    public  ResponseEntity<List<Menu>>findAll(){
        List<Menu> menuList =this.menuService.findAll();
        return ResponseEntity.ok(menuList);
    }

}
