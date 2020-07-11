package app.slt.soa.filereader.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "user")
@Getter
@Setter
public class User {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private boolean active;

	@Column(name="roles")
	private String roles;
}
