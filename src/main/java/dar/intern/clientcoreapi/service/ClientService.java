package dar.intern.clientcoreapi.service;

import dar.intern.clientcoreapi.model.ClientModel;

import java.util.List;

public interface ClientService {
    void createClient (ClientModel clientModel);

    List<ClientModel> getAllClients();

    ClientModel getClientById(String clientId);

    void updateClient(String clientId, ClientModel clientMOdel);

    void deleteClient(String clientId);


}
