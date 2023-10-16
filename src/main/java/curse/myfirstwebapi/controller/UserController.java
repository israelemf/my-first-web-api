package curse.myfirstwebapi.controller;

import curse.myfirstwebapi.model.User;
import curse.myfirstwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    // Um Controller é apenas uma chamada a camada de serviço
    @Autowired
    private UserRepository userRepository;

    // URI para buscar os usuarios do banco
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Buscar o parâmetro do método através da informação passada na URI
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);

        return "Usuário " + id + " excluido";
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userRepository.save(user);

        return user;
    }
}
