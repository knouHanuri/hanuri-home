package hanuri.website.service;

import hanuri.website.dao.MemberMapper;
import hanuri.website.domain.dto.Member;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberMapper memberMapper;

    public CustomOAuth2UserService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        // 기본 OAuth2 사용자 정보 가져오기
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // OAuth2 제공자 이름 (Google, Facebook 등)
        String provider = userRequest.getClientRegistration().getRegistrationId();

        // 제공자가 발급한 사용자 ID
        String providerId = oAuth2User.getName();

        // 사용자 이메일
        String username = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");


        // 데이터베이스에 사용자 저장 (존재 여부 확인 후 저장)
       Member member = memberMapper.findByProviderAndProviderId(provider, providerId).orElseGet(Member::new);
        if (member.getEmail() == null) {
            member = new Member();
            member.setProvider(provider);
            member.setProviderId(providerId);
            member.setUsername(username);
            member.setName(name);
            member.setEmail(username);
            if(username != null){
                int atIndex = username.indexOf("@");
                String defaultPassword = atIndex != -1 ? username.substring(0, atIndex) : username; // '@' 없으면 전체 반환
                member.setPassword(defaultPassword);
            }
            memberMapper.save(member);
        }

        // OAuth2User 반환
        return oAuth2User;
    }


}
