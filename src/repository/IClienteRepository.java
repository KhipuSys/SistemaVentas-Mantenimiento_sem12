package repository;

import model.Cliente;

public interface IClienteRepository {
    void guardar(Cliente cliente);
    Cliente buscarPorDni(String dni);
}
