package ir.mci.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHORITIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    private String username;

    @Column(name = "authority")
    private String authority;


    @ManyToMany(mappedBy = "authorities")
    private List<UserDto> users;

    // Getters and setters
}
