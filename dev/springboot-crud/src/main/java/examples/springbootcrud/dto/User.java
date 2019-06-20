package examples.springbootcrud.dto;



import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
@Data
@EqualsAndHashCode(of = {"id"}) //primary만 비교해도 ㅇㅇ
public class User{
    @Id //primary
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "이름을 입력하세요")
    private String name;
    @NotBlank(message = "이메일을 입력하세요")
    private String email;
    private String passwd;
}