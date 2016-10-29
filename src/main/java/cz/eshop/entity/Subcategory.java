package cz.eshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by frantisek.manak on 2.10.2016.
 */
@Entity
@Table(name = "SUBCATEGORY")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBCATEGORY_ID", unique = true)
    private Long id;

    @Column(name = "SUBCATEGORY_NAME", unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Column(name = "DESCRIPTION")
    private String Description;

    @ManyToMany(mappedBy = "subcategories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }



    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}