package dar.intern.clientcoreapi.controller;

import dar.intern.clientcoreapi.model.ClientModel;
import dar.intern.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String checkClientApi(){
        return "ApiIsWorking at " + env.getProperty("local.server.port");
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId){
        return clientService.getClientById(clientId);
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<String>("Succesfully created", HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId,
                                                   @Valid @RequestBody ClientModel clientModel){
        clientService.updateClient(clientId, clientModel);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.OK);

    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteCLientById(@PathVariable String clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }
}
