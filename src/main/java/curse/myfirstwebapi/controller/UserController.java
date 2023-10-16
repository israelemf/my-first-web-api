package curse.myfirstwebapi.controller;

import curse.myfirstwebapi.model.User;
import curse.myfirstwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    // Um Controller é apenas uma chamada a camada de serviço
    @Autowired
    private UserRepository userRepository;

    // URI para buscar os usuarios do banco
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Buscar o parâmetro do método através da informação passada na URI
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }
}
