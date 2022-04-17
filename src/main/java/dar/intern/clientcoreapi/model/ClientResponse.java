package dar.intern.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponse {
    private String clientId;
    private String Name;
    private String Surname;
    private String email;
}
