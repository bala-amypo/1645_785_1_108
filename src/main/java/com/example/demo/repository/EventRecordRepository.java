// package com.example.demo.repository;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.EventRecord;

// @Repository
// public interface EventRecordRepository extends JpaRepository<EventRecord,Long>{
//     boolean existsByEventCode(String eventCode);
//     EventRecord findByEventCode(String eventCode);
// }
package com.example.demo.repository;

import com.example.demo.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRecordRepository extends JpaRepository<EventRecord, Long> {

    boolean existsByEventCode(String eventCode);

    Optional<EventRecord> findByEventCode(String eventCode);
}
