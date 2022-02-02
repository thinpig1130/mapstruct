/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstruct.t003_2;

import me.manylove.mapstruct.s02multiplesourceobject.DeliveryAddressMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mapstruct.factory.Mappers;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CompositionTest {

    private StorageMapper mapper = Mappers.getMapper(StorageMapper.class);

    @Test
    @DisplayName("t003_2 TEST")
    public void shouldCompose() {

        Date now = new Date();
        Date anHourAgo = new Date( now.getTime() - 3600 * 1000 );
        Date anHourFromNow = new Date( now.getTime() + 3600 * 1000 );

        ShelveDto shelve = new ShelveDto();
        shelve.setGroupName( "blue things" );
        shelve.setMaxWeight( 10.0d );
        shelve.setPath( "row5" );
        shelve.setStandNumber( 3 );

        BoxDto box = new BoxDto();
        box.setDesignation( "blue item" );
        box.setGroupName( "blue stuff" );
        box.setShelve( shelve );

        BoxEntity boxEntity = mapper.INSTANCE.map( box );

        // box
        assertThat( boxEntity ).isNotNull();
        assertThat( boxEntity.getCreationDate() ).isBetween( anHourAgo, anHourFromNow );
        assertThat( boxEntity.getId() ).isNull();
        assertThat( boxEntity.getName() ).isEqualTo( "blue stuff" );
        assertThat( boxEntity.getLabel() ).isEqualTo( "blue item" );

        // shelve
        ShelveEntity shelveEntity = boxEntity.getShelve();
        assertThat( shelveEntity.getCreationDate() ).isBetween( anHourAgo, anHourFromNow );
        assertThat( shelveEntity.getId() ).isNull();
        assertThat( shelveEntity.getName() ).isEqualTo( "blue things" );
        assertThat( shelveEntity.getPath() ).isEqualTo( "row5" );
        assertThat( shelveEntity.getStandNumber() ).isEqualTo( 3 );
        assertThat( shelveEntity.getWeightLimit() ).isEqualTo( 10.0d );

    }
}
