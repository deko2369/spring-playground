package net.dkok.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySQLConfigTest {
    @Autowired
    MySQLConfig config;

    @Test
    public void loadMySQLConfigTest() {
        assertThat(config.getUsername(), is(equalTo("testuser")));
        assertThat(config.getPassword(), is(equalTo("testpassword")));
        assertThat(config.getHost(), is(equalTo("testhost")));
        assertThat(config.getPort(), is(equalTo(10)));
    }
}
