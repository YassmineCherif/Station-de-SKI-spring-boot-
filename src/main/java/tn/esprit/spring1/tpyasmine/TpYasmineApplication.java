package tn.esprit.spring1.tpyasmine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableAspectJAutoProxy //Activer l'Aspect dans l'application
@EnableScheduling //we add it when we use Spring Scheduler

public class TpYasmineApplication {

    public static void main(String[] args) {

        SpringApplication.run(TpYasmineApplication.class, args);
    }

}
