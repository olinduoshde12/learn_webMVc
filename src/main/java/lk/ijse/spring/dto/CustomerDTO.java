package lk.ijse.spring.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private double salary;

}
