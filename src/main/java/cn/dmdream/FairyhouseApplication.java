package cn.dmdream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.dmdream.**"})
public class FairyhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FairyhouseApplication.class, args);
    }

}
