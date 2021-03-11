package lacerda.luhan.deliveryorderservice.service;

import lacerda.luhan.deliveryorderservice.model.Order;
import lacerda.luhan.deliveryorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(@Validated Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Integer id) {
        Optional<Order> getById = orderRepository.findById(id);
        if (getById.isPresent())
            return getById.get();
        else
            return null;
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}