package shop.wuchang.wuchangblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.wuchang.wuchangblog.core.exception.csr.ExceptionApi400;
import shop.wuchang.wuchangblog.core.exception.ssr.Exception400;
import shop.wuchang.wuchangblog.core.exception.ssr.Exception500;
import shop.wuchang.wuchangblog.core.util.MyFileUtil;
import shop.wuchang.wuchangblog.dto.user.UserRequest;
import shop.wuchang.wuchangblog.model.user.User;
import shop.wuchang.wuchangblog.model.user.UserRepository;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;    //securityConfig에등록함

    @Value("${file.path}")
    private String uploadFolder;

    //insert, update, delete -> try catch 처리
    @Transactional
    public void 회원가입(UserRequest.JoinInDTO joinInDTO) {

        // 1. 유저네임 중복확인
        Optional<User> userOP = userRepository.findByUsername(joinInDTO.getUsername());
        if(userOP.isPresent()){
            throw new Exception400("username", "유저네임이 중복되었어요");
        }

        try {
            // 2.패스워드 암호화
            joinInDTO.setPassword(passwordEncoder.encode(joinInDTO.getPassword()));
            // 3. DB 저장
            userRepository.save(joinInDTO.toEntity());
        } catch (Exception e) {
            throw new Exception500("회원가입 실패 : " + e.getMessage());
        }

    }   //더티체킹, DB 세션 종료(OSIV=false)

    public User 회원프로필보기(Long id) {
        User userPS = userRepository.findById(id)
                .orElseThrow(()->new Exception400("id", "해당 유저가 존재하지 않습니다"));
        return userPS;
    }

    @Transactional
    public User 프로필사진수정(MultipartFile profile, Long id) {
        String uuidImageName = MyFileUtil.write(uploadFolder, profile);
        User userPS = userRepository.findById(id)
                .orElseThrow(()->new Exception500("로그인 된 유저가 DB에 존재하지 않음"));
        try {
            userPS.changeProfile(uuidImageName);
            return userPS;
        }catch (Exception e){
            throw new Exception500("프로필 사진 등록 실패 : "+e.getMessage());
        }
    } // 더티체킹 업데이트

    public void 유저네임중복체크(String username) {
        Optional<User> userOP = userRepository.findByUsername(username);
        if(userOP.isPresent()){
            throw new ExceptionApi400("username", "유저네임이 중복되었어요");
        }
    }

    public User 회원정보보기(Long id) {
        User userPS = userRepository.findById(id)
                .orElseThrow(()->new Exception400("id", "해당 유저가 존재하지 않습니다"));
        return userPS;
    }
}
