package ap1.carlos.caycho.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("product")
public class Product {

    @Id
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
    private String brand;
    private Boolean available;

    @Column("created_at")
    private LocalDate createdAt;
}