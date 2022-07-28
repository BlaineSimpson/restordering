/* AdminLoginController.java
 Implementation the AdminLogin controller
 Author: Ali Mohamed (219113505)
 Date: 27 July 2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.service.IAdminLoginService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/admin")
@Slf4j
public class AdminLoginController {

    private final IAdminLoginService adminService;
    @Autowired
    public AdminLoginController(IAdminLoginService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("save")
    public ResponseEntity<AdminLogin> save(@Valid @RequestBody AdminLogin admin){
        log.info("Save Request: {}", admin);
        AdminLogin insert = adminService.save(admin);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<AdminLogin>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<AdminLogin> find = adminService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<AdminLogin> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-admin")
    public ResponseEntity<AdminLogin> delete(AdminLogin admin){
        log.info("Delete Request: {}", admin);
        this.adminService.delete(admin);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<AdminLogin>> findAll(){
        List<AdminLogin> adminLoginList = adminService.findAll();
        return ResponseEntity.ok(adminLoginList);
    }
}
