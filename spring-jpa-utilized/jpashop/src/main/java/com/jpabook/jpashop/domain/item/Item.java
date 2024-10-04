package com.jpabook.jpashop.domain.item;

import com.jpabook.jpashop.domain.Category;
import com.jpabook.jpashop.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    //==비즈니스 로직==//
    /**
     * ex) 재고를 늘고 줄이는 로직-
     * => 도메인 주도 설계
     * 엔티티 자체에 해결할 수 있는 것들을 엔티티 안에 비즈니스 로직을 넣는 것이 객체지향적이다. -> 응집력이 있다
     * 예를 들어, stockQuantity라는 재고 수량은 엔티티가 가지고 있기 때문에 수량을 늘릴 때 엔티티에서 로직을
     * 넣어주는 것이 객체 지향적이다.
     * */

    /**
     * stock 증가
     * */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     * */
    public void removeStock(int quantity) {
        int resultStock = this.stockQuantity - quantity;

        if (resultStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = resultStock;
    }
}
