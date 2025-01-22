package hanuri.website.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("interceptor : " + requestURI);

        // layout과 관련된 요청은 체크하지 않음
        if (requestURI.contains("layout") ||
                requestURI.contains("pages") ||
                requestURI.equals("/") ||
                requestURI.equals("/about")) {
            return true;
        }
        HttpSession session = request.getSession(false);

/*        if(session == null || session.getAttribute("user") == null){
            System.out.println("session is null");
            response.sendRedirect("/login");
            return false;
        }*/
        return true;
    }
}
