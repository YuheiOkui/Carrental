package carrental.domain.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.User;

public interface Userrepository extends JpaRepository<User,Integer>{

}
