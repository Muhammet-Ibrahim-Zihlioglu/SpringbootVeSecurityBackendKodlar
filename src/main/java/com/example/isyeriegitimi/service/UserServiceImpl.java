/*package com.example.isyeriegitimi.service;

import com.example.isyeriegitimi.model.User;
import com.example.isyeriegitimi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById((long)id);
    }
    @Override
    public User saveUser(User users) {
        return userRepository.save(users);
    }
    @Override
    public User updateUser(User users) {
        User user = userRepository.findById(users.getId()).orElse(null);
        if(users.getUsername()!=null) user.setUsername(users.getUsername());
        if(users.getPassword()!=null) user.setPassword(users.getPassword());
        System.out.println("Kullanıcı başarıyla güncellendi.");
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(int id) {
        User user=userRepository.findById((long) id).orElse(null);
        if(user != null){
            userRepository.deleteById(user.getId());
            System.out.println("Kullanıcı başarıyla silindi.");
        }else{
            System.out.println("Hata");
        }
    }
}

*/