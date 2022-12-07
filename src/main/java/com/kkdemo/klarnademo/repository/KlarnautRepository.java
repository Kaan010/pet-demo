package com.kkdemo.klarnademo.repository;

import com.kkdemo.klarnademo.model.Klarnaut;
import com.kkdemo.klarnademo.model.dto.RequestDto;
import com.kkdemo.klarnademo.model.enums.AninmalType;
import com.kkdemo.klarnademo.model.enums.Role;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface KlarnautRepository extends JpaRepository<Klarnaut,Long> {

    Optional<Klarnaut> findByUserName(String userName);

    List<Klarnaut> findByAccepterDateBeginIsLessThanEqualAndAccepterDateEndGreaterThanEqualAndAcceptedAnimalsContains(LocalDate requestDateBegin,
                                                                                                    LocalDate requestDateEnd,
                                                                                                    AninmalType aninmalType);

    List<Klarnaut> findByAccepterDateBeginIsLessThanEqualAndAccepterDateEndGreaterThanEqual(LocalDate requestDateBegin,
                                                                          LocalDate requestDateEnd);
}
