package edu.iu.habahram.databsedemo.controllers;


import edu.iu.habahram.databsedemo.model.OrderData;
import edu.iu.habahram.databsedemo.repository.OrderFileRepository;
import edu.iu.habahram.databsedemo.repository.OrderRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

    OrderFileRepository orderFileRepository;
    OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository, OrderFileRepository orderFileRepository) {
        this.orderRepository = orderRepository;
        this.orderFileRepository = orderFileRepository;
    }

    @PostMapping
    public int add(@RequestBody OrderData order) {
        String username = getTheCurrentLoggedInCustomer();
        order.setCustomerUserName(username);
        OrderData saved = orderRepository.save(order);
        return saved.getId();
    }

    private String getTheCurrentLoggedInCustomer() {
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = "";
        if(principal instanceof Jwt) {
            username = ((Jwt) principal).getSubject();
        }
        return username;
    }

    @PostMapping("/{id}")
    ResponseEntity<List<OrderData>> findByOrder() {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if(username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<OrderData> orders = orderRepository.findAllByCustomerUserName(username);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping
    public ResponseEntity<List<OrderData>> findAllByCustomer() {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if(username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<OrderData> orders = orderRepository.findAllByCustomerUserName(username);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/search")
    public ResponseEntity<List<OrderData>> search(@RequestBody OrderData order) {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if(username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Example<OrderData> example = Example.of(order);
        List<OrderData> orders = (List<OrderData>) orderRepository.findAll(example);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
}
