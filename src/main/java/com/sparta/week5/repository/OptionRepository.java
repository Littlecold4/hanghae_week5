package com.sparta.week5.repository;

import com.sparta.week5.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options,Long> {
}
