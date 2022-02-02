package me.manylove.mapstruct.t003_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private String manufacturer;
    private int seatCount;
    private String type;
    private EngineDto engine;
}