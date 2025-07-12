package com.DGAPR.RH.repository;
import com.DGAPR.RH.Model.Attestation;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface AttestationRepository extends jpaRepository<Attestation, Long> {
    List<Attestation> findByEmployeeId(Long employeeId);

    static void save(Attestation attestation);
}
