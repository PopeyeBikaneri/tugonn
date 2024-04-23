package com.tugonn.respository;

import com.tugonn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chhavi Priya Tanwar
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    List<User> findByEmail(String email);
//    List<User> findByPhone(String phone);
//    List<User> findByUsername(String username);

}
