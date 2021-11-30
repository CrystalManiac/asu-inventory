-- types

create type hardware_status as enum ('NEW','IN_USE', 'NOT_USED', 'REPAIR_REQUIRED', 'ON_REPAIR', 'NEED_UTILIZATION', 'UTILIZED');
create type hardware_type as enum ('MEDIA','PC', 'PC_COMPONENT', 'OFFICE_EQT', 'PERIPHERAL');
create type software_status as enum ('UNUSED','IN_USE', 'EXPIRED');
create type workplace_status as enum ('WORKING','NOT_WORKING', 'ON_REPAIR');


-- locations

create table locations
(
    id                  serial primary key,
    building            varchar(500)  not null,
    floor               integer not null,
    auditory            integer not null,
    UNIQUE (building, floor, auditory)
);

-- workplaces

create table workplaces
(
    id                  serial primary key,
    location_id         int not null,
    workplace_name      varchar(500)  not null,
    status              workplace_status not null,
    CONSTRAINT fk_workplace_location
        FOREIGN KEY (location_id)
            REFERENCES locations (id)
            ON DELETE CASCADE
);

-- hardware

create table hardware
(
    id                  serial primary key,
    hardware_name       varchar(500)  not null,
    type                hardware_type not null,
    status              hardware_status not null,
    workplace_id        int,
    CONSTRAINT fk_hardware_workplace
        FOREIGN KEY (workplace_id)
            REFERENCES workplaces (id)
);

-- software

create table software
(
    id                  serial primary key,
    software_name       varchar(500)  not null,
    status              software_status not null,
    expiration_date     timestamp with time zone,
    workplace_id        int,
    CONSTRAINT fk_software_workplace
        FOREIGN KEY (workplace_id)
            REFERENCES workplaces (id)
);





