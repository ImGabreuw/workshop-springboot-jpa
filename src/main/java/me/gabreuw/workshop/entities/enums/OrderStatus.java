package me.gabreuw.workshop.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @Getter
    private final int code;

    public static OrderStatus valueOf(int code) {
        return Arrays.stream(OrderStatus.values())
                .filter(orderStatus -> orderStatus.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid OrderStatus Code."));
    }
}
