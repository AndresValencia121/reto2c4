
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceAccessory;
import Reto2_Web.modelo.Accessory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class AccessoryRepositorio {
    @Autowired
    private InterfaceAccessory repository;

    public List<Accessory> getAll() {
        return repository.findAll();
    }

    public Optional<Accessory> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Accessory create(Accessory clothe) {
        return repository.save(clothe);
    }

    public void update(Accessory clothe) {
        repository.save(clothe);
    }
    
    public void delete(Accessory clothe) {
        repository.delete(clothe);
    }
}
