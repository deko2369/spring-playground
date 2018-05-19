package net.dkok;

import net.dkok.config.MySQLConfig;
import net.dkok.ika.Ika;
import net.dkok.ika.IkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    private MySQLConfig config;
    private IkaRepository ikaRepository;

    @Autowired
    public AppCommandLineRunner(MySQLConfig mySQLConfig, IkaRepository ikaRepository) {
        this.config = mySQLConfig;
        this.ikaRepository = ikaRepository;
    }

    private void printVcapServicesVariables() {
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());
        System.out.println(config.getHost());
        System.out.println(config.getPort());
    }

    private void executeSqlite() {
        Ika ika = new Ika();
        ika.setName("MAN MEN MI");

        ikaRepository.save(ika);

        for (Ika i : ikaRepository.findAll()) {
            System.out.println(i);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        printVcapServicesVariables();
        executeSqlite();
    }
}
