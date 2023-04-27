package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity
{
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;



    //Bad Logic. 1:N - N:1 로 풀어쓸 것
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
                joinColumns = @JoinColumn(name = "CATEGORY_ID"),
                inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

}
