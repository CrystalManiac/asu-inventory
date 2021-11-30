package asu.edu.ru.inventory.constant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HardwareStatus {
    NEW("Новый"),
    IN_USE("Используется"),
    NOT_USED("Не используется"),
    REPAIR_REQUIRED("Требуется ремонт"),
    ON_REPAIR("В ремонте"),
    NEED_UTILIZATION("К списанию"),
    UTILIZED("Списан");

    private final String description;
}
