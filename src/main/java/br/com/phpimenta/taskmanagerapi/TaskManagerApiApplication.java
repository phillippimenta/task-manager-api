package br.com.phpimenta.taskmanagerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class responsible for starting the Rest API
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@SpringBootApplication
public class TaskManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApiApplication.class, args);
    }

}
