package com.codegym.demo.repository;

import com.codegym.demo.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequestRepository extends PagingAndSortingRepository<Request,Long> {
    @Query(value="select * from requests r where r.requestStatus = 0",nativeQuery = true)
    Page<Request> findAllByRequestStatusIs0(Pageable pageable);

    @Query (value="select * from requests r where r.requestStatus = 1",nativeQuery = true)
    Page<Request> findAllByRequestStatusIs1(Pageable pageable);

    @Query (value="select * from requests r where r.requestStatus = 2",nativeQuery = true)
    Page<Request> findAllByRequestStatusIs2(Pageable pageable);

    @Query (value="select * from requests r where r.requestStatus = 3",nativeQuery = true)
    Page<Request> findAllByRequestStatusIs3(Pageable pageable);

    @Query (value="select * from requests r where r.userId =:id order by r.requestId Desc",nativeQuery = true)
    Page<Request> findEachUserRequest(@Param("id") Long id, Pageable pageable);
}
