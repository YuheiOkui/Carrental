package carrental.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Userのエンティティ
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usr")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String name;
	private String birth;
	private String sex;
	private String pass;
	//権限の判定
	@Enumerated(EnumType.STRING)
	private RoleName authority;
}
