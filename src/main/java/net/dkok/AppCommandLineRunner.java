package net.dkok;

import net.dkok.config.MySQLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    private MySQLConfig config;

    @Autowired
    public AppCommandLineRunner(MySQLConfig mySQLConfig) {
        this.config = mySQLConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());
        System.out.println(config.getHost());
        System.out.println(config.getPort());
    }
}
