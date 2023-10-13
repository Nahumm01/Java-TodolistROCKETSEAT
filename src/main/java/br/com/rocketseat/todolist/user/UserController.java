package br.com.rocketseat.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {

        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            System.out.println("Usuário já existente!");
            return null;
        } else {
            
        }

        var userCreated = this.userRepository.save(userModel);
        return userCreated;

    }
}
