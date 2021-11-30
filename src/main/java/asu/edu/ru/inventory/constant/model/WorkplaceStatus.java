package asu.edu.ru.inventory.constant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WorkplaceStatus {
    WORKING("Работает"),
    NOT_WORKING("Не работает"),
    ON_REPAIR("В ремонте");

    private final String description;
}
