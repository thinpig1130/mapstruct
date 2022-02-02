package me.manylove.mapstruct.t003_1;

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
    private Engine engine;
}