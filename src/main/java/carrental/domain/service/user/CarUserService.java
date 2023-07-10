package carrental.domain.service.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import carrental.domain.model.User;
import carrental.domain.repository.user.UserRepository;

/**
 * ユーザー情報サービス
 * 
 * （ｱﾌﾟﾘｹｰｼｮﾝにおけるﾕｰｻﾞｰの詳細情報の取得や登録を
 * 行うためのｻｰﾋﾞｽｸﾗｽを作成）
 * 
 * @author Tanaka
 *
 */

@Service
public class CarUserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encorder;//暗号化

	//ﾌﾙﾈｰﾑIDでﾕｰｻﾞｰ情報を取得する
	//DBに登録されていなければ"ﾌﾙﾈｰﾑ is not found"
	@Override
	public UserDetails loadUserByUsername(String fullnameId) throws UsernameNotFoundException {
		User user = userRepository.findById(fullnameId).orElseThrow(() 
				-> new UsernameNotFoundException(fullnameId + "is not found"));
		return new CarUserDetail(user);
	}
	public void userupdateregist(User user) {
		userRepository.save(user);
	}
	public void userregist(User user) {
		user.setPassword(encorder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public List<User> getUserAll(){
		return userRepository.findAll();
	}
	public User findById(String fullnameId) {
		return userRepository.findById(fullnameId).get();
	}
}
