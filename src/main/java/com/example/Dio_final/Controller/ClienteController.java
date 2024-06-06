package com.example.Dio_final.Controller;

import com.example.Dio_final.Model.Bibliotecario;
import com.example.Dio_final.Model.Cliente;
import com.example.Dio_final.Repositories.ClienteRepository;
import com.example.Dio_final.Service.BibliotecarioService;
import com.example.Dio_final.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @Autowired
    private ClienteRepository clienteRepository;
    
      @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteRepository.save(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }

    @PostMapping("/{clienteId}/retirar-livro/{bibliotecarioId}")
    public ResponseEntity<String> retirarLivro(@PathVariable Long clienteId, @PathVariable Long bibliotecarioId) {
        Optional<Cliente> clienteOptional = clienteService.getClienteById(clienteId);
        Optional<Bibliotecario> bibliotecarioOptional = bibliotecarioService.getById(bibliotecarioId);

        if (clienteOptional.isPresent() && bibliotecarioOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Bibliotecario bibliotecario = bibliotecarioOptional.get();
            // Lógica para retirar o livro
            return new ResponseEntity<>("Livro retirado com sucesso por " + cliente.getNome() + " com a ajuda de " + bibliotecario.getNome(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Não é possível retirar o livro sem cliente e bibliotecário associados.", HttpStatus.BAD_REQUEST);
        }
    }
}