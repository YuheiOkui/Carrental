package carrental.domain.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
	private String fullnameId;
	private String username;
	private Date birth;	
	private String sex;
	private String pass;
	//権限の判定
	@Enumerated(EnumType.STRING)
	private RoleName authority;
}
