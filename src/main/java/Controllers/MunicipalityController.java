package Controllers;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.MunicipalityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/municipality")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;

    @GetMapping
    public List<Municipality> findAll(){
        List <Municipality> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Municipality findById(@PathVariable Long id){
        Municipality result = repository.findById(id).get();
        return result;
    }
    @PostMapping
    public Municipality insert(@RequestBody Municipality municipality){
        Municipality result = repository.save(municipality);
        return result;
}
