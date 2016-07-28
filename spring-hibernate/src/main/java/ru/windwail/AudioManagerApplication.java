package ru.windwail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by pfisher on 9/27/14.
 */

@Configuration
@EnableJpaRepositories
@Import({RepositoryRestMvcConfiguration.class})
@EnableAutoConfiguration
public class AudioManagerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AudioManagerApplication.class, args);
    }

}
