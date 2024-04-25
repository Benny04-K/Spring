package com.jsp.crud.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.crud.dao.Order;
import com.jsp.crud.dao.Product;
import com.jsp.crud.repository.OrderRepository;  


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();	
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOrder(Order orderRequestDTO) {
      
        Order order = new Order();
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder != null) {
       
            return orderRepository.save(existingOrder);
        }

        return null;
    }
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    public double calculateTotal(List<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    public void addProductToOrder(Product product, Order order, boolean isEmployeeOrder) {
        if (product.isExpired()) {
            if (isEmployeeOrder) {
                order.getProducts().add(product);
                orderRepository.save(order);
            } else {
                throw new IllegalArgumentException("Expired products cannot be added to regular orders.");
            }
        } else {
            order.getProducts().add(product);
            orderRepository.save(order);
        }
    }
}


