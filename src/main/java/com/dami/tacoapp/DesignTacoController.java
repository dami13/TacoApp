package com.dami.tacoapp;

import com.dami.tacoapp.model.Order;
import com.dami.tacoapp.model.User;
import com.dami.tacoapp.model.dto.OrderDto;
import com.dami.tacoapp.service.TacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class DesignTacoController {
    private final TacoService tacoService;

    @PostMapping
    public void processOrder(@RequestBody OrderDto orderDto, @AuthenticationPrincipal User user) {
        var newOrder = new Order().from(orderDto);
//        newOrder.setUser(user);
        // TODO save
    }
}

