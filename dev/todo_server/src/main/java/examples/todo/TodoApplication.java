package examples.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoApplication implements WebMvcConfigurer { // web애플리케이션에대한 추가적인 설정을 하길 원할 경우 WebMvcConfigurer인터페이스를 구현한 후 메소드를 오버라이딩 한다.
    // CORS설정을 추가한다. javascript가 도메인이 달라도 호출을 허용한다.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}
