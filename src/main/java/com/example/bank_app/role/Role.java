package com.example.bank_app.role;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    @ManyToMany
    private List<User> userList;
}
