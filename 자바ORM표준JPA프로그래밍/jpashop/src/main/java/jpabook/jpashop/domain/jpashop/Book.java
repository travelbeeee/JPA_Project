package jpabook.jpashop.domain.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity @Getter @Setter
public class Book extends Item{
    private String ISBN;
}
