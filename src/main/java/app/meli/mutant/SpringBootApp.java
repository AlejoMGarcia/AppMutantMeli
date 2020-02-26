package app.meli.mutant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = {"app.meli"})
public class SpringBootApp {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}