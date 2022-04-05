package dar.intern.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    private String clientId;
    private String Name;
    private String Surname;
    private String email;

}
