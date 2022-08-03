package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication //replaces by @RestController and @EnableAutoConfiguration , @ComponentScan
public class RestaurantOrderingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantOrderingApplication.class, args);
    }

    @RequestMapping("/")
    String home(){
        return "I'm here.";
    }
}
