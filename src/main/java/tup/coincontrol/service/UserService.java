package tup.coincontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tup.coincontrol.model.User;
import tup.coincontrol.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    
    @Autowired
    private final UserRepository userRepository;

    public void createUser(User user){
        
        userRepository.save(user);
    }
}
