package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;
import wap.config.JwtService;
import wap.dto.Role;
import wap.dto.UserDTO;
import wap.model.User;
import wap.repository.UserRepository;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public Optional<User> findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

    public boolean addUser(String username, String password, String email, String company){
        User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(Role.USER)
                .company(company)
                .build();
        userRepository.save(user);
        return true;
    }

    public String findUsernameById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
        {
            User user1 = user.get();
            String username = user1.getUsername();
            return username;
        }
        else
        {
            return null;
        }
    }

    public Optional<User> getUserByToken(String token){
        Optional<User> user = userRepository.findByUsername(jwtService.extractUsername(token));
        return user;
    }
}
