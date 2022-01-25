package me.manylove.mapstruct.s02multiplesourceobject;

import me.manylove.mapstruct.p002simple.SimpleSourceDestinationMapper;
import me.manylove.mapstruct.s01singlesourceobject.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryAddressMapperTest {

    private DeliveryAddressMapper mapper = Mappers.getMapper(DeliveryAddressMapper.class);

    @Test
    @DisplayName("멀티소스오브젝트 테스트")
    void mutiObject(){
        // given a customer
        Customer customer = new Customer();
        customer.setFirstName("Max");
        customer.setLastName("Powers");

        // and some address
        Address homeAddress = new Address();
        homeAddress.setStreet("123 Some Street");
        homeAddress.setCounty("Nevada");
        homeAddress.setPostalcode("89123");

        // when calling DeliveryAddressMapper::from
        DeliveryAddress deliveryAddress = mapper.from(customer, homeAddress);

        // then a new DeliveryAddress is created, based on the given customer and his home address
        assertEquals(deliveryAddress.getForename(), customer.getFirstName());
        assertEquals(deliveryAddress.getSurname(), customer.getLastName());
        assertEquals(deliveryAddress.getStreet(), homeAddress.getStreet());
        assertEquals(deliveryAddress.getCounty(), homeAddress.getCounty());
        assertEquals(deliveryAddress.getPostalcode(), homeAddress.getPostalcode());
    }

    @Test
    @DisplayName("기존 객체 업데이트 테스트")
    void updateMappingTarget(){
        // given a delivery address
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setForename("Max");
        deliveryAddress.setSurname("Powers");
        deliveryAddress.setStreet("123 Some Street");
        deliveryAddress.setCounty("Nevada");
        deliveryAddress.setPostalcode("89123");

        // and some new address
        Address newAddress = new Address();
        newAddress.setStreet("456 Some other street");
        newAddress.setCounty("Arizona");
        newAddress.setPostalcode("12345");

        // when calling DeliveryAddressMapper::updateAddress
        DeliveryAddress updatedDeliveryAddress = mapper.updateAddress(deliveryAddress, newAddress);

        // then the *existing* delivery address is updated
        assertSame(deliveryAddress, updatedDeliveryAddress);

        assertEquals(deliveryAddress.getStreet(), newAddress.getStreet());
        assertEquals(deliveryAddress.getCounty(), newAddress.getCounty());
        assertEquals(deliveryAddress.getPostalcode(), newAddress.getPostalcode());
    }
}