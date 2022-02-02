package me.manylove.mapstruct.t003_1;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    @Mapping(source = "make", target = "manufacturer")
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}

/**
 * 맴버변수의 이름이 다른 경우만, @Mapping 에노테이션을 이용하여 매칭되는 이름에 대해 명시하여 준다.
 * enum 타입 속성과 string 타입 속성이 일치하는 경우, 자동으로 변환하는 필드를 생성하여 준다.
 */