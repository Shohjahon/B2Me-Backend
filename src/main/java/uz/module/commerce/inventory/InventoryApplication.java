package uz.module.commerce.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableAutoConfiguration
@ComponentScan("uz.module.commerce.inventory")
@PropertySources({
		@PropertySource(value = "classpath:exception.properties", encoding = "UTF-8")
		,
		@PropertySource(value = "classpath:messages.properties", encoding = "UTF-8")
})
@EnableScheduling
@EnableSwagger2
@EnableAsync
@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
