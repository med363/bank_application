package com.example.bank_app.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    /*role objet interne lil apllication pas besoin de faire un controller*/

}
