package JpaAPi.demo.repostiroy;

import JpaAPi.demo.entity.Item;
import JpaAPi.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
