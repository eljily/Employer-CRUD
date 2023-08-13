package net.sidibrahim.Employer.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=4,max = 20)
    private String name;
    private String Email;
    @Min(300)
    private double Salary;
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;
}
