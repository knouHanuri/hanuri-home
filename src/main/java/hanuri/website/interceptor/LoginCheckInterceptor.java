package hanuri.website.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("interceptor : " + requestURI);
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            System.out.println("session is null");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
