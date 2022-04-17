package dar.intern.clientcoreapi.controller;


import dar.intern.clientcoreapi.model.ClientRequest;
import dar.intern.clientcoreapi.model.ClientResponse;
import dar.intern.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ClientResponse getClientById(@RequestParam String clientId){
        return clientService.getClientById(clientId);
    }
    @GetMapping("/all")
    public List<ClientResponse> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest){
        return clientService.createClient(clientRequest);
    }

    @PutMapping
    public ClientResponse updateClient(@RequestParam String clientId,
                                       @RequestBody ClientRequest clientRequest){

        clientRequest.setClientId(clientId);
        return clientService.updateClientById(clientRequest);
    }

    @DeleteMapping
    public void deleteClient(@RequestParam String clientId) {
        clientService.deleteClientById(clientId);
    }

}
