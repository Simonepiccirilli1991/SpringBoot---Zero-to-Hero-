package com.spring.zerotohero.base.bootstrap;

import com.spring.zerotohero.base.model.Customer;
import com.spring.zerotohero.base.model.Registry;
import com.spring.zerotohero.base.repository.CustomerRepo;
import com.spring.zerotohero.base.repository.RegistryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class BootStrapData implements CommandLineRunner {

    private CustomerRepo customerRepo;
    private RegistryRepo registryRepo;

    public BootStrapData(CustomerRepo customerRepo, RegistryRepo registryRepo) {
        this.customerRepo = customerRepo;
        this.registryRepo = registryRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("BootStrap started");

        var customer = new Customer();
        customer.setEmail("Email@mail.com");
        customer.setPsw("psw1");
        customer.setNickName("nickName1");

        var registry = new Registry();
        registry.setName("name aa");
        registry.setSurname("Surname aa");
        registry.setPhone("12345");
        registry.setCountry("Usa");
        registry.setZipCode("00100");

        customerRepo.save(customer);
        registry.setCustomer(customer);
        registryRepo.save(registry);

        System.out.println("BootStrap finished");
        System.out.println("Customer count: " + customerRepo.count());
        System.out.println("Registry count: " + registryRepo.count());
    }
}
