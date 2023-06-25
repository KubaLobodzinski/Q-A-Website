package wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wap.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/user")
public class UserController {


        @Autowired
        private final UsersService usersService = new UsersService();

        @GetMapping("/profile")
        public ModelAndView userProfile(HttpServletRequest request) {
                Cookie[] cookies = request.getCookies();
                String token = "";
                boolean isLogged = false;
                if (cookies != null) {
                        for (Cookie cookie : cookies) {
                                if ("token".equals(cookie.getName())) {
                                        token = cookie.getValue();
                                        isLogged = true;
                                }
                        }
                }
                ModelAndView model = new ModelAndView();
                model.setViewName("profile.html");
                model.addObject("user", usersService.getUserByToken(token));
                model.addObject("isLogged", isLogged);
                return model;
        }
}
