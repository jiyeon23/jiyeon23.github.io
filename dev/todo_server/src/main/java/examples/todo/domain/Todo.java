package examples.todo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;

@Entity
@Table(name = "TODO")
@Data
@EqualsAndHashCode(of = {"id"})
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    private Boolean done;
}
