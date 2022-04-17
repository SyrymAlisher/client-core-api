package dar.intern.clientcoreapi.service;

import dar.intern.clientcoreapi.model.ClientRequest;
import dar.intern.clientcoreapi.model.ClientResponse;
import dar.intern.clientcoreapi.repository.ClientEntity;
import dar.intern.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.getClientEntitiesBy().stream()
                .map(client -> modelMapper.map(client, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.getClientEntitiesByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClientById(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        ClientEntity dbEntity = clientRepository.getClientEntitiesByClientId(clientRequest.getClientId());
        clientEntity.setId(dbEntity.getId());
        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntitiesByClientId(clientId);
    }
}
