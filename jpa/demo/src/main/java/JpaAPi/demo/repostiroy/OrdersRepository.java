package JpaAPi.demo.repostiroy;

import JpaAPi.demo.entity.Orders;
import JpaAPi.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    List<Orders> findByUserId(Long userId);
}
