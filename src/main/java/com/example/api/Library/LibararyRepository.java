package com.example.api.Library;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibararyRepository extends JpaRepository<Libarary,Long> {
    Optional<Libarary> findBookByPublisher(String publisher);
}
