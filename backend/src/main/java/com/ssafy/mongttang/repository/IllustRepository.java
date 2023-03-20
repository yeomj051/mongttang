package com.ssafy.mongttang.repository;

import com.ssafy.mongttang.entity.Challenge;
import com.ssafy.mongttang.entity.Illust;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllustRepository extends JpaRepository<Illust, Integer> {
}
