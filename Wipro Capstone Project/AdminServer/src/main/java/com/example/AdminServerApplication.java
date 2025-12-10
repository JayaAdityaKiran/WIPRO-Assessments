package com.example;

import com.example.service.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AdminServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
    
    @Bean
    CommandLineRunner initDefaultAdmin(AdminService adminService) {
        return args -> adminService.createDefaultAdmin();
    }
}
