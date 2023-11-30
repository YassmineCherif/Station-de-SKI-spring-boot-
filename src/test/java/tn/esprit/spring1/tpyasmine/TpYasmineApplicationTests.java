package tn.esprit.spring1.tpyasmine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring1.tpyasmine.Aspects.LoggingAspect;
import tn.esprit.spring1.tpyasmine.Service.ICoursService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LoggingAspectTest {

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private ICoursService coursService;

    @Test
    void contextLoads() {
        assertNotNull(loggingAspect);
    }

    @Test
    void logCoursServiceMethods() {

        assertNotNull(coursService.findAll());
    }

    // Add more test methods if needed
}
