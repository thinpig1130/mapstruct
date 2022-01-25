package me.manylove.mapstruct.p001beforeuse.Dto;

import me.manylove.mapstruct.p001beforeuse.Entity.SampleEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class SampleDtoTest {

    @Test
    @DisplayName("맵스트럭트 사용 전, 전통적인 변환방법")
    void prevMapstruct(){

        SampleDto sampleDto = new SampleDto("다애", "kwondarc@plani.co.kr", new ArrayList<>(Arrays.asList("씩씩한","다애","자존감")), 36 );
        System.out.println(sampleDto);

        SampleEntity sampleEntity = sampleDto.toEntity();
        System.out.println(sampleEntity);

    }

}