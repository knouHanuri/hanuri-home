package hanuri.website.service;

import hanuri.website.dao.MemberMapper;
import hanuri.website.domain.dto.Login.LoginRequest;
import hanuri.website.domain.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final MemberMapper memberMapper;

    @Autowired
    public LoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Member login(LoginRequest loginRequest){
        return memberMapper.login(loginRequest);

    }


}
