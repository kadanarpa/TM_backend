package co.edu.usco.TM.persistence.repository;

import co.edu.usco.TM.persistence.entity.veterinary.Contact;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT c FROM Contact c " +
            "LEFT JOIN c.owner o " +
            "LEFT JOIN c.vet v " +
            "WHERE (:ownerID IS NULL OR c.owner.id = :ownerID) " +
            "AND (:vetID IS NULL OR c.vet.id = :vetID) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND ((:ownerID IS NOT NULL " +
            "AND (:name IS NULL OR v.name ILIKE %:name%) " +
            "AND (:username IS NULL OR v.username ILIKE %:username%) " +
            "AND (:email IS NULL OR v.email ILIKE %:email%) " +
            "AND (:specialty IS NULL OR v.specialty ILIKE %:specialty%)" +
            "AND (:veterinary IS NULL OR v.veterinary ILIKE %:veterinary%))" +
            "OR (:vetID IS NOT NULL " +
            "AND (:name IS NULL OR o.name ILIKE %:name%) " +
            "AND (:username IS NULL OR o.name ILIKE %:username%) " +
            "AND (:email IS NULL OR o.email ILIKE %:email%)))",
            nativeQuery = false)
    Page<Contact> findUserContacts(
            @Param("ownerID") Long ownerID,
            @Param("vetID") Long vetID,
            @Param("status") String status,
            @Param("name") String name,
            @Param("username") String username,
            @Param("email") String email,
            @Param("specialty") String specialty,
            @Param("veterinary") String veterinary,
            Pageable pageable
    );

}
