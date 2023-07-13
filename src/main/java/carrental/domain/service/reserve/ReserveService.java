package carrental.domain.service.reserve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.domain.model.Reserve;
import carrental.domain.repository.reserve.ReserveRepository;

/**
 * 予約機能のサービス
 * @author 奥井
 */
@Service
public class ReserveService {
	
	@Autowired
	ReserveRepository reserveRepository;
	
	public void save(Reserve reserve) {
		reserveRepository.save(reserve);
	}
	
	public Optional<Reserve> findReserve(Integer reserveid) {
		return reserveRepository.findById(reserveid);
	}
	
	public List<Reserve> findReserveCar(Integer carid) {
		return reserveRepository.findByCaridOrderByReserveidAsc(carid);
	}
	
	public List<Reserve> findReserveUser(String fullnameid) {
		return reserveRepository.findByFullnameidOrderByReserveidAsc(fullnameid);
	}
	
	public List<Reserve> findAllReserve() {
		return reserveRepository.findAll();
	}
	
	public void deleteReserve(Integer reservid) {
		reserveRepository.deleteById(reservid);
	}
	
}
