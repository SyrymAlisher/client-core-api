package dar.intern.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequest {
    private String clientId;
    @NotNull(message = "Name can not be empty")
    private String Name;
    @NotNull(message = "Surname can not be empty")

    private String Surname;
    @Email(message="incorrect email")
    private String email;
}
