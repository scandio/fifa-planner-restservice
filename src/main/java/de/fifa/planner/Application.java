package de.fifa.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the fifa planner rest service
 *
 * Created by stefanmuecke on 17.10.16.
 */
@SpringBootApplication
public class Application {
    /**
     * the main method
     *
     * @param args an array of arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
