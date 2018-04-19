

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
class Application {
    static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args)
    }
}