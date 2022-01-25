package me.manylove.mapstruct.s01singlesourceobject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerDtoMapper {

    @Mapping(source = "firstName", target = "forename")
    @Mapping(source = "lastName", target = "surname")
    CustomerDto from(Customer customer);

}