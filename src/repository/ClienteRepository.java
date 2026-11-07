package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorDni(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clientes;
    }

    //UPN ZZZ//
}
