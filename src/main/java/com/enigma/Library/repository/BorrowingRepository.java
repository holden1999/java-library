package com.enigma.Library.repository;

import com.enigma.Library.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, String> {
}
