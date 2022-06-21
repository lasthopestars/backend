package JpaAPi.demo.service;

import JpaAPi.demo.entity.Item;
import JpaAPi.demo.entity.Orders;
import JpaAPi.demo.entity.Users;
import JpaAPi.demo.repostiroy.ItemRepository;
import JpaAPi.demo.repostiroy.OrdersRepository;
import JpaAPi.demo.repostiroy.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;
    private final ItemRepository itemRepository;

    public Orders saveOrders(Long userId, Long itemId) {
        Users users = usersRepository.findById(userId).get();
        Item item = itemRepository.findById(itemId).get();
        Orders orders = new Orders();
        orders.setItem(item);
        orders.setUser(users);
        Integer price = item.getPrice();
        users.setCredit(users.getCredit()-price);
        usersRepository.save(users);
        return ordersRepository.save(orders);
    }

    public List<Orders> findMyOrderList(Long userId) {
        return ordersRepository.findByUserId(userId);
    }
}
