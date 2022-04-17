package dar.intern.clientcoreapi.service;

import dar.intern.clientcoreapi.model.ClientRequest;
import dar.intern.clientcoreapi.model.ClientResponse;
import dar.intern.clientcoreapi.repository.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    List<ClientResponse> getAllClients();
    ClientResponse getClientById(String clientId);
    ClientResponse updateClientById(ClientRequest clientRequest);
    void deleteClientById(String clientId);
}
