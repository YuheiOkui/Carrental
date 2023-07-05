package carrental.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.User;

//ユーザーリポジトリー
public interface Userrepository extends JpaRepository<User,String>{

}
