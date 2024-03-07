package com.it_moisesmoreno.TourismAndTravelMS.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.it_moisesmoreno.TourismAndTravelMS.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByIsActiveTrue();
    List<User> findByIsActiveFalse();
    List<User> findByRole(User.Role role);
    List<User> findByUsernameAndEmail(String username, String email);
    List<User> findByUsernameOrEmail(String username, String email);
    public Integer countById(Integer id);
}
