package me.manylove.mapstruct.p001beforeuse.Dto;

import lombok.*;
import me.manylove.mapstruct.p001beforeuse.Entity.SampleEntity;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleDto {
    private String name;
    private String email;
    private List<String> infos;
    private int age;

    public SampleEntity toEntity(){
        return SampleEntity.builder()
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .value("Yuki")
                .infos(this.infos)
                .build();
    }

    public SampleDto toDto(SampleEntity sampleEntity){
        return SampleDto.builder()
                .name(sampleEntity.getName())
                .email(sampleEntity.getEmail())
                .age(sampleEntity.getAge())
                .infos(sampleEntity.getInfos())
                .build();
    }
}
