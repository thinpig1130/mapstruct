package me.manylove.mapstruct.p002simple;

import org.mapstruct.Mapper;

@Mapper
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}

/**
 * 맵핑할 객체의 속성명이 동일한 경우.
 * 위와 같이 인터페이스를 작성하여 주면 된다.
 */
