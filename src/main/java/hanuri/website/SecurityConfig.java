package hanuri.website;

import hanuri.website.domain.dto.Member;
import hanuri.website.service.CustomOAuth2UserService;
import hanuri.website.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final MemberService memberService;

    @Autowired
    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService, MemberService memberService) {
        this.customOAuth2UserService = customOAuth2UserService;
        this.memberService = memberService;
    }
    // 시큐리티 필터 메서드
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        // 인가 동작 순서 : 위에서 부터 아래로 순서대로 ! 따라서 순서 유의 (anyRequest 특히)

                        //.requestMatchers("/","/bootstrap/**","/image/**","/js/**","/css/**").permitAll()
                        //.requestMatchers("/about/**","/members/new","/login").permitAll()
                        //.requestMatchers("/study/**","/board/**").permitAll()
                        .requestMatchers("/**").permitAll()
                        // 구글 OAuth2 인증 엔드포인트 허용
                        .requestMatchers("/oauth2/authorization/google").permitAll()
                        //.requestMatchers("/admin").hasRole(EMembershipLevel.admin.name())
                        // ** : 와일드카드
                        //.requestMatchers("/my/**").hasAnyRole(EMembershipLevel.admin.name(), EMembershipLevel.normal.name())
                        .anyRequest().authenticated()
                );

        // 로그인 설정
        http
                .formLogin((auth) -> auth.loginPage("/oauth2/login")
                        //.loginProcessingUrl("/loginProc")
                        .permitAll()
                );
        http
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/login") // 커스텀 로그인 페이지 설정
                        .defaultSuccessUrl("/", true) // 로그인 성공 후 리다이렉트 URL
                        .userInfoEndpoint(userInfo -> userInfo
                                // OAuth2 인증 성공 후 처리할 UserService를 설정 (OidcUserService를 제거)
                                .userService(customOAuth2UserService) // OAuth2UserService를 사용
                        )
                        .successHandler((request, response, authentication) -> {
                            // OAuth2 인증 성공 후, OAuth2User 정보를 세션에 저장
                            OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

                            // OAuth2 제공자 이름 (Google, Facebook 등)
                            String provider = ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();
                            // 제공자가 발급한 사용자 ID
                            String providerId = oAuth2User.getName();

                            Optional<Member> member = memberService.findByProviderInfo(provider,providerId);
                            // 세션에 저장
                            member.ifPresent(value -> request.getSession().setAttribute("user", value));
                            response.sendRedirect("/"); // 로그인 성공 후 이동할 URL
                        })
                );

        // 로그아웃 URL 설정
        http
                .logout((auth) -> auth
                        .logoutUrl("/logout")  // 로그아웃 URL 설정
                        .logoutSuccessUrl("/login")  // 로그아웃 성공 후 리디렉션할 URL 설정
                        .invalidateHttpSession(true)  // 세션 무효화
                        .clearAuthentication(true)    // 인증 정보 제거
                        .permitAll()
                );


        // csrf : 사이트 위변조 방지 설정 (스프링 시큐리티에는 자동으로 설정 되어 있음)
        // csrf기능 켜져있으면 post 요청을 보낼때 csrf 토큰도 보내줘야 로그인 진행됨 !
        // 개발단계에서만 csrf 잠시 꺼두기
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }

    // BCrypt password encoder를 리턴하는 메서드
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
