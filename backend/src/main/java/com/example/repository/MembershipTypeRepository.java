package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MembershipType;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {
	
//	@Modifying
//    @Transactional
//    @Query(value = "INSERT INTO gym_membership_type (gym_id, membership_type_id) VALUES (:gymId, :membershipTypeId)", nativeQuery = true)
//    void addMembershipTypeToGymNative(@Param("gymId") Integer gymId, @Param("membershipTypeId") integer membershipTypeId);

	
	// Custom query methods can be defined here if needed
	// For example:
	// List<MembershipType> findByName(String name);
	// List<MembershipType> findByDurationMonths(int durationMonths);

}
