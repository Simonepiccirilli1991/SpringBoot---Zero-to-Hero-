package com.spring.zerotohero.base.bootstrap;

import com.spring.zerotohero.base.model.Customer;
import com.spring.zerotohero.base.model.Registry;
import com.spring.zerotohero.base.model.shared.Opera;
import com.spring.zerotohero.base.model.shared.OperaTemporanea;
import com.spring.zerotohero.base.repository.CustomerRepo;
import com.spring.zerotohero.base.repository.RegistryRepo;
import com.spring.zerotohero.base.service.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

public class BootStrapData implements CommandLineRunner {

    private CustomerRepo customerRepo;
    private RegistryRepo registryRepo;

    @Autowired
    SharedService sharedService;

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


        var opera = new Opera();
        var operaTemp = new OperaTemporanea();

        opera.setCodiceOpera("operaCodice");
        opera.setAutore("autore");
        opera.setDataUltimaInstallazione(LocalDateTime.now());

        operaTemp.setCodiceOpera("codiceOperaTemp");
        operaTemp.setIstruzioniMontaggio("Istruzioni montaggio");
        operaTemp.setDataUltimaInstallazione(LocalDateTime.now().minusHours(1));

        sharedService.aggiungiOpera(opera);
        sharedService.aggiungiOpera(operaTemp);

        System.out.println("List count: "+ sharedService.getOpere().size());

        var resp = sharedService.getOpera(new Opera().getClass());

        System.out.println("Response: "+ resp.toString());
    }
}
