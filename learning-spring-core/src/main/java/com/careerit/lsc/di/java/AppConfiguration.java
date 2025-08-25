package com.careerit.lsc.di.java;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    public ContractController contractController() {
        ContractController contractController = new ContractController();
        contractController.setContactService(contactService());
        return contractController;
    }


    @Bean
    public ContactService contactService() {
       ContactServiceImpl contactService = new ContactServiceImpl();
       contactService.setContactDao(contactDao());
       return contactService;
    }

    @Bean
    public ContactDao contactDao() {
        return new ContactDaoImpl();
    }
}
