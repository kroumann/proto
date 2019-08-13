package proto;


import static proto.ProtoConstants.CSS_PATH;
import static proto.ProtoConstants.HEIGHT;
import static proto.ProtoConstants.PROJECT_TITLE;
import static proto.ProtoConstants.WIDTH;
/*
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
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication (scanBasePackages={"proto"})
//@EnableConfigurationProperties(StorageProperties.class)
public class ProtoApp extends Application {

    private ConfigurableApplicationContext springContext;

    private static final Logger log = LoggerFactory.getLogger(ProtoApp.class);
    private Scene scene;

    public static void main(String[] args) {
        launch(ProtoApp.class, args);
        //SpringApplication.run(ProtoApp.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ProtoApp.class);
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        startApplication(stage);
    }

    private void startApplication(final Stage primaryStage) throws Exception {
        log.info("Starting {}!", PROJECT_TITLE);

        FXMLLoader loader = new FXMLLoader(ProtoApp.class.getResource("/view/Login.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);
        //scene.getStylesheets().add("/view/proto.css");
		primaryStage.setTitle(PROJECT_TITLE);
		//primaryStage.setHeight(HEIGHT);
		//primaryStage.setWidth(WIDTH);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}



    /*
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
*/

}
