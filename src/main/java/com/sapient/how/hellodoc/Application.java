package com.sapient.how.hellodoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

//@EnableSpringDataWebSupport // For supporting paging object in controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
