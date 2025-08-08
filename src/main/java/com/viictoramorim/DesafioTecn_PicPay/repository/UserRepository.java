package com.viictoramorim.DesafioTecn_PicPay.repository;

import com.viictoramorim.DesafioTecn_PicPay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
