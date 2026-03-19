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
@Table("category")
public class Category {

    @Id
    private Long id;

    private String name;
    private String description;
    private String status;

    @Column("created_at")
    private LocalDate createdAt;
}