package shop.wuchang.wuchangblog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.wuchang.wuchangblog.model.board.Board;
import shop.wuchang.wuchangblog.model.board.BoardRepository;
import shop.wuchang.wuchangblog.model.user.User;
import shop.wuchang.wuchangblog.model.user.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WuchangblogApplication extends DummyEntity{

    @Profile("dev")
    @Bean
    CommandLineRunner init(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, BoardRepository boardRepository) {
        return args -> {
            User ssar = newUser("ssar", passwordEncoder);
            User cos = newUser("cos", passwordEncoder);
            userRepository.saveAll(Arrays.asList(ssar, cos));

            List<Board> boardList = new ArrayList<>();
            for (int i = 1; i < 11; i++) {
                boardList.add(newBoard("제목"+i, ssar));
            }
            for (int i = 11; i < 21; i++) {
                boardList.add(newBoard("제목"+i, cos));
            }
            boardRepository.saveAll(boardList);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(WuchangblogApplication.class, args);
    }

}
