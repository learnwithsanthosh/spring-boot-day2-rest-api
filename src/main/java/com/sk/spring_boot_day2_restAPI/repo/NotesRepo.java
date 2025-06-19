package com.sk.spring_boot_day2_restAPI.repo;

import com.sk.spring_boot_day2_restAPI.dao.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Integer> {
}
