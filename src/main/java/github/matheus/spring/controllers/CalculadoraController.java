package github.matheus.spring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( path = "/calculadora")
public class CalculadoraController {

    @GetMapping( path = "/somar/{a}/{b}")
    public int somar(@PathVariable(name = "a") int a, @PathVariable(name = "b") int b) {
        return a + b;
    }

    @GetMapping( path = "/subtrair")
    public int subtrair(@RequestParam(name = "valor1") int valor1, @RequestParam(name = "valor2") int valor2) {
        return valor1 - valor2;
    }
}
