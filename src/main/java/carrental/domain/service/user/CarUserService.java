package carrental.domain.service.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import carrental.domain.model.User;
import carrental.domain.repository.user.Userrepository;

	//未完成
@Service
public class CarUserService implements UserDetailsService{

	@Autowired
	Userrepository userRepository;
	
	@Autowired
	PasswordEncoder encorder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username + "is not found"));
		return new CarUserDetail(user);
	}
	public void userregist(User user) {
		user.setPass(encorder.encode(user.getPass()));
		userRepository.save(user);
	}
	public List<User> getUserAll(){
		return userRepository.findAll();
	}
	public User findById(String fullnameId) {
		return userRepository.findById(fullnameId).get();
	}
}
