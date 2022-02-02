/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstruct.t003_2;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoxEntity {

    private Date creationDate;
    private Long id;
    private String name;
    private String label;
    private ShelveEntity shelve;

}
