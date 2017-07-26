package com.yandimirov.navi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "ROOM_ID")
    private long id;

    @Column(name = "ROOM_NAME")
    private String name;
}
