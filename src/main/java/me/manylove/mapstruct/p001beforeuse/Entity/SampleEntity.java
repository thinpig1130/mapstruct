package me.manylove.mapstruct.p001beforeuse.Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleEntity {
    private Long id;
    private String name;
    private String email;
    private List<String> infos;
    private int age;
    private String value;
}
