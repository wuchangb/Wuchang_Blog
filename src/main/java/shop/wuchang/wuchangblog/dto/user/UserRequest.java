package shop.wuchang.wuchangblog.dto.user;

import lombok.Getter;
import lombok.Setter;
import shop.wuchang.wuchangblog.model.user.User;

import javax.validation.constraints.NotEmpty;

public class UserRequest {
    @Getter @Setter
    public static class JoinInDTO {
        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
        @NotEmpty
        private String email;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role("USER") //enum 사용해도 됨
                    .status(true)
                    .profile("person.png")
                    .build();
        }
    }

    @Getter @Setter
    public static class UpdateInDTO {
        @NotEmpty
        private String password;
        @NotEmpty
        private String email;
    }
}
