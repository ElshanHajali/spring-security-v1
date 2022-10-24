package az.company.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("v1/test")
public class TestController {
    @GetMapping
    public String test() {
        log.info("ActionLog.test.start");
        return "Test passed!";
    }
}
