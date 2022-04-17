package dar.intern.clientcoreapi.service.serviceOld;

import dar.intern.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImplOld implements ClientServiceOld {
    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();


    static {
        ClientModel clientModel1 = new ClientModel("clientId1","ClientName1", "ClientSurname1", "email1");
        ClientModel clientModel2 = new ClientModel("clientId2","ClientName2", "ClientSurname2", "email2");
        ClientModel clientModel3 = new ClientModel("clientId3","ClientName3", "ClientSurname3", "email3");
        clientMap.put(clientModel1.getClientId(), clientModel1);
        clientMap.put(clientModel2.getClientId(), clientModel2);
        clientMap.put(clientModel3.getClientId(), clientModel3);
    }
    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClient(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClient(String clientId) {
        clientMap.remove(clientId);
    }
}
