package carrental.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author 黒川
 *ユーザー権限の判定
 */


@Getter
@AllArgsConstructor
public enum RoleName implements UserValues{

	ADMIN("ADMIN","ADMIN"),
	USER("USER","USER");
	
	private final String value;
	private final String text;

}
