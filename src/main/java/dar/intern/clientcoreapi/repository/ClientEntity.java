package dar.intern.clientcoreapi.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="clients")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String clientId;

    @Column(nullable = false, length = 50)
    private String Name;

    @Column(nullable = false, length = 50)
    private String Surname;

    @Column(nullable = false, length = 50)
    private String email;
}
