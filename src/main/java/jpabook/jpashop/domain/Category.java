package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category
{
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    //Bad Logic. 1:N - N:1 로 풀어쓸 것
    @ManyToMany
    @JoinTable(name = "CATOGORY_ITEM",
                joinColumns = @JoinColumn(name = "CATEGORY_ID"),
                inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Category> items;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child;
}
