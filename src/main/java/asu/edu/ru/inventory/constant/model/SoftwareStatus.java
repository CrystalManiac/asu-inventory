package asu.edu.ru.inventory.constant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SoftwareStatus {
    IN_USE("Используется"),
    UNUSED("Не используется"),
    EXPIRED("Срок лицензии истек");

    private final String description;
}
