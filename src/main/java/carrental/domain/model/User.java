package carrental.domain.model;



import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * ユーザーのエンティティ作成
 * 項目５つ
 * 
 * @author Tanaka
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usr")
public class User {
	@Id
	private String fullnameId;
	private String username;
	private Timestamp birth;	//元々はDateだった
	private String sex;
	private String password;
	//権限の判定
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
}
