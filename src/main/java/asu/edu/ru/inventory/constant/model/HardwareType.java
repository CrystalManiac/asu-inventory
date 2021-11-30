package asu.edu.ru.inventory.constant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HardwareType {
    MEDIA("Медиа-техника"),
    PC("Компьютер (в сборе)"),
    PC_COMPONENT("Комплекующие ПК"),
    OFFICE_EQT("Офисная техника"),
    PERIPHERAL("Периферия");

    private final String description;
}
