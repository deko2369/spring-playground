package net.dkok.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// http://engineering.pivotal.io/post/spring-boot-injecting-credentials/

@Data
@Configuration
@ConfigurationProperties("vcap.services.mysqlservice.credentials")
public class MySQLConfig {
    private String username;
    private String password;
    private String host;
    private int port;
}
