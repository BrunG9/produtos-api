package bruno.project.produtosapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Column
    @Id()
    private String id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;

}
