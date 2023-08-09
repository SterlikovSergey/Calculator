package by.sterlikov.calculator.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/*@Builder*/
public class User {
    private String name;
    private String userName;
    private String password;
}
