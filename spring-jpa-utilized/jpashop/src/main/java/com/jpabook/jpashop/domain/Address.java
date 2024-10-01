package com.jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // JPA 스펙상 추가되어야 하는 기본생성자 -> protected 로 막습니다.
    protected Address() {
    }

    // Setter 제거 -> 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만듭니다.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
