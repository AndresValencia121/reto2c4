
package Reto2_Web.controlador;

import Reto2_Web.servicio.UserService;
import Reto2_Web.modelo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Valencia Trujillo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
     @Autowired
    /**
     * Atributo de tipo UserService
     */
     private UserService userService;
     
     @GetMapping("/all")
    /**
     * Metodo que lista todos los usuarios registrados en la DB
     * @return todos los usuarios
     */
     public List<User> getAll() {
        return userService.getAll();
    }
      @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metodo que crea un usuario
     * @param user
     * @return el usuario creado
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metodo que actualiza un registro de usuario en la DB
     * @param user
     * @return el usuario actualizado
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * Metodo que borra un usuario de la DB
     * @param id
     * @return el usuario borrado
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    @GetMapping("/{email}/{password}")
    /**
     * Metodo que autentica un usuario mediante su email
     * @param email
     * @param password
     * @return confirmacion de autenticación
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    @GetMapping("/emailexist/{email}")
    /**
     * Metodo que verifica si un email existe en la DB
     * @param email
     * @return
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
