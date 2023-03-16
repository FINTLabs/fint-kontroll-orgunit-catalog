package no.fintlabs.repository;

import no.fintlabs.orgUnit.OrgUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrgUnitRepository extends JpaRepository<OrgUnit,Long> {

    Optional<OrgUnit> findByOrganisationUnitIdIgnoreCase(String organisationUnitId);

    Optional<OrgUnit> findOrgUnitByResourceIdEqualsIgnoreCase(String resourceid);

}



