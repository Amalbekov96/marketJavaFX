package kg.kushtar.market.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public interface BaseCrudController<S, T>{

    @PostMapping("/save")
    S save(@RequestBody S s);
    @PutMapping("/update")
    S update(@RequestBody S s);
    @GetMapping("/all")
    List<S> findAll();
    @GetMapping("/findById/{id}")
    S findById(@PathVariable T t);
    @DeleteMapping("/deleteById/{id}")
    void deleteById(@PathVariable("id") T t);
}
