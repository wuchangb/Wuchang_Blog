package shop.wuchang.wuchangblog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.wuchang.wuchangblog.model.user.User;
import shop.wuchang.wuchangblog.model.user.UserRepository;

@SpringBootApplication
public class WuchangblogApplication {

    @Bean
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        return args -> {
            User ssar = User.builder()
                    .username("ssar")
                    .password(passwordEncoder.encode("1234"))
                    .email("ssar@nate.com")
                    .role("USER")
                    .profile("person.png")
                    .status(true)
                    .build();
            userRepository.save(ssar);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(WuchangblogApplication.class, args);
    }

}
