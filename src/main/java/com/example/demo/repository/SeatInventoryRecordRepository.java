// // package com.example.demo.repository;

// // import com.example.demo.model.SeatInventoryRecord;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;

// // @Repository
// // public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {

// //     SeatInventoryRecord findByEventId(Long eventId);
// // }
// package com.example.demo.repository;

// import com.example.demo.model.SeatInventoryRecord;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {

//     SeatInventoryRecord findByEvent_Id(Long eventId);
// }
package com.example.demo.repository;

import com.example.demo.model.SeatInventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatInventoryRecordRepository extends JpaRepository<SeatInventoryRecord, Long> {

    Optional<SeatInventoryRecord> findByEventId(Long eventId);
}
