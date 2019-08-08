package proto;


import proto.cache.Cache;
import proto.cache.RedisCache;
import proto.storage.StorageProperties;
import proto.storage.StorageService;
import proto.validators.GroupValidator;
import proto.validators.OrderValidator;
import proto.validators.ProductValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.validation.Validator;
import redis.clients.jedis.Jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"proto"})
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
//			storageService.deleteAll();
			storageService.init();
		};
	}

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public Validator productValidator(){
	    return new ProductValidator();
    }
    @Bean
    public Validator groupValidator(){
        return new GroupValidator();
    }
    @Bean
    public Validator orderValidator(){
        return new OrderValidator();
    }

    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;
    @Value("${redis.password}")
    private String redisPassword;
//    @Bean
    private Jedis redisCliFactory(){
        Jedis jedis = new Jedis(redisHost, redisPort);
        jedis.auth(redisPassword);
        return jedis;
    }

    @Bean
    @Autowired
    public Cache cacheObject(ObjectMapper objectMapper){
        return new RedisCache(objectMapper, redisCliFactory());
    }


}
