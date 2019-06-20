package my.examples.hr;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

    @Override
    @Transactional // lazy로딩은 transaction안에서 동작해야한다.
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }
    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }
}


// ctrl + alt + O 는 import정리
