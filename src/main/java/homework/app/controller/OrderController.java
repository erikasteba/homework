package homework.app.controller;

import homework.app.dto.OrderDTO;
import homework.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<OrderDTO> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") Long id, Model model) {
        OrderDTO order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order-detail";
    }
}

