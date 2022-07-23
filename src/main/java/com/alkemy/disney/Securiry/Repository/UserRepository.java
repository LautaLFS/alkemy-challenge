package com.alkemy.disney.Securiry.Repository;

import com.alkemy.disney.Securiry.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String username);

}
