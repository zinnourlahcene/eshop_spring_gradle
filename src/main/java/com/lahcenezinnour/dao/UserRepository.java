package com.lahcenezinnour.dao;

import com.lahcenezinnour.domain.Users;
import com.lahcenezinnour.exception.UserNotFoundException;
import com.lahcenezinnour.util.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lahcen on 4/4/17.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("Select u from Users u where u.userEmail = :userEmail and u.userPassword = :userPassword")
    Users getUser(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword) throws UserNotFoundException;

    @Query("Select u from Users u where userEmail = :userEmail")
    Users getEmail(@Param("userEmail") String userEmail);

    default Login login(String userEmail, String userPassword){
        Login login;
        if(getUser(userEmail, userPassword) == null){
            if(getEmail(userEmail) == null){
                login = new Login(false, "Error Email");
            }else{
                login = new Login(false, "Error Password");
            }
        }else{
            login = new Login(true, "");
        }
        return login;
    }

    Users findByUserEmail(String userEmail);
}
