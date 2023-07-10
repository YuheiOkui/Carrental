package carrental.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.User;

/**
 * 
 * ユーザーのリポジトリ作成
 * （UserRepository)
 * 
 * @author Tanaka
 *
 */
public interface UserRepository extends JpaRepository<User,String>{
	User findByUsername(String fullnameId);

}
