package carrental.domain.repository.reserve;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.Reserve;
/**
 * 予約機能のレポジトリー
 * @author 奥井
 */
public interface ReserveRepository extends JpaRepository<Reserve, Integer> {
	List<Reserve> findByCaridOrderByReserveidAsc(Integer carid);
	List<Reserve> findByFullnameidOrderByReserveidAsc(String fullnameid);
}
