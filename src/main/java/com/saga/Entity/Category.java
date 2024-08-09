package com.saga.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="Category")
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 46835149772133976L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name="Sort_Order")
    private int sortOrder;

    @Column(name = "Status")
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Job> jobs=new HashSet<Job>();
}
