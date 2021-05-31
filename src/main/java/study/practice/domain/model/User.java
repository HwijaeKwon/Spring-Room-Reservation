package study.practice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "usr")
@AllArgsConstructor
@Getter
public class User implements Serializable {

    @Id @Column(name = "user_id")
    private String userId;

    private String firstName;

    private String lastName;

    private String passWord;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

}
