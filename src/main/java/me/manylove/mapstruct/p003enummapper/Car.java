package me.manylove.mapstruct.p003enummapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private CarType type;
}