package com.kkdemo.klarnademo.repository;

import com.kkdemo.klarnademo.model.MatchesRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchesRequestRepository extends JpaRepository<MatchesRequest,Long> {

//    @Query("select " +
//            "k.userName as nameOfRequester, "+
//            " from MatchesRequest mr left join Klarnaut k on k.id = mr.helperId " +
//            "where mr.requesterId=:userId")
//    List<IMatchesRequest> findAllMatchesOfUser(@Param("klarnautId") Long userId);

    List<MatchesRequest> findAllByHelperId(Long helperId);

    List<MatchesRequest> findAllByRequesterId(Long requesterId);


}
