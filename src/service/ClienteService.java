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

        dni = (dni == null) ? null : dni.trim();
        nombre = (nombre == null) ? null : nombre.trim();

        if (!Validaciones.validarDni(dni)) {
            Console.error("DNI inválido");
            return;
        }

        if (nombre == null || nombre.isEmpty()) {
            Console.error("Nombre de cliente obligatorio");
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
