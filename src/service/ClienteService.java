package service;

import model.Cliente;
import util.Console;
import util.Validaciones;
import repository.IClienteRepository;

public class ClienteService {

    //Inversión de control: uso de interfaces
    private IClienteRepository clienteRepo;

    public ClienteService(IClienteRepository repo) {
        this.clienteRepo = repo;
    }

    public void registrarCliente(String dni, String nombre, String tipo) {

        if (!Validaciones.validarDni(dni)) {
            Console.error("DNI inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
