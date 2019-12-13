package com.example.GymDiaryBackend.repositories;

import com.example.GymDiaryBackend.model.GymMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<GymMember, Integer> {
    GymMember findByEmail(String email);
}
