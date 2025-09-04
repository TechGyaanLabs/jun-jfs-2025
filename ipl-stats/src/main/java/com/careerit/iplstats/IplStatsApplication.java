package com.careerit.iplstats;

import com.careerit.iplstats.config.OpenAIConfiguration;
import com.careerit.iplstats.domain.AppUser;
import com.careerit.iplstats.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

@SpringBootApplication
public class IplStatsApplication implements CommandLineRunner {

    @Autowired
    private ConfigurableEnvironment env;

    @Value("${greetings.message}")
    private String greetings;

    @Value("${app.teams}")
    private List<String> teamName;


    @Autowired
    private AppUserRepo appUserRepo;


    @Autowired
    private OpenAIConfiguration openAIConfiguration;

    public static void main(String[] args) {
		SpringApplication.run(IplStatsApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        System.out.println(greetings);
        System.out.println(env.getProperty("greetings.message"));
        System.out.println(openAIConfiguration);

        teamName.forEach(System.out::println);


     /*   List<AppUser> list = new ArrayList<>();
        AppUser appUser1 = new AppUser();
        appUser1.setUsername("john");
        appUser1.setPassword("john@123");
        appUser1.setEmail("john@gmail.com");
        list.add(appUser1);

        AppUser appUser2 = new AppUser();
        appUser2.setUsername("krish");
        appUser2.setPassword("krish@123");
        appUser2.setEmail("krish@outlook.com");
        list.add(appUser2);

        AppUser appUser3 = new AppUser();
        appUser3.setUsername("rajesh");
        appUser3.setPassword("rajesh@123");
        appUser3.setEmail("rajesh@gmail.com");
        list.add(appUser3);

        appUserRepo.saveAll(list);*/

        // Find user who are using gmail

        List<AppUser> gmailUsers = appUserRepo.findByEmailContainingIgnoreCase("gmail.com");
        System.out.println(gmailUsers.size());
    }

}
