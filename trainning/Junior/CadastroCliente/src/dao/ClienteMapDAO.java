package dao;

import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDao{

   private Map<Long[], Cliente> map;

   public ClienteMapDAO() {
        this.map = new HashMap<>();
   }

   public Boolean cadastrar(Cliente cliente){
        if (this.map.containsKey(cliente.getId())) {
            return false;
        }
        this.map.put(cliente.getId(), cliente);
        return true;
    

   }

}
