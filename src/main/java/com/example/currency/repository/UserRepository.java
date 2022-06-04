package com.example.currency.repository;


import com.example.currency.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = "select u.* from users u where u.user_name =:findByUserNameAndEMail or u.email =:findByUserNameAndEMail")
    UserEntity findByUserNameAndEMail(String findByUserNameAndEMail);

}
