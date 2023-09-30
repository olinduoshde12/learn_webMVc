package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {

    @Id
    private String id;
    private String name;
    private String address;
    private double salary;


}
