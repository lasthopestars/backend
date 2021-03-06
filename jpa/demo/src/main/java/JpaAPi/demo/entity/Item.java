package JpaAPi.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "Item_id")

    private Long id;
    private String itemName;
    private Integer price;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Orders> orders =new ArrayList<>();



    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }


}
