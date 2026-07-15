package com.austin.student_marketplace;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMarketplaceApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                        .ignoreIfMalformed().ignoreIfMissing().load();

        dotenv.get("DATABASE_URL");
        SpringApplication.run(StudentMarketplaceApplication.class, args);
    }

}
