package com.improved.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long>{
    Optional<User> findByEmail(String email); //이미 생성된 사용자인지 아닌지 여부 확인
}
