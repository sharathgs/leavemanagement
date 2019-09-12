package com.leavemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leavemanagement.model.MyLeaves;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<MyLeaves, Integer> {

	@Query(value = "select * from my_leaves where employee_id= :employeeId and from_date>= :fromDate && to_date<= :toDate", nativeQuery = true)
	List<MyLeaves> findByBetweenDate(int employeeId, LocalDate fromDate, LocalDate toDate);
}
