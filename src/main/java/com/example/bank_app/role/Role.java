package com.example.bank_app.role;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {
    @Id @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    @ManyToMany
    private List<User> userList;
}
