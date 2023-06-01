package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wap.repository.UserRepository;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public void findByUsername(String username){
        userRepository.findByUsername(username);
    }
}
