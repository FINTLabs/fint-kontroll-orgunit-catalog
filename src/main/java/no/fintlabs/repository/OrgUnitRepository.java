package no.fintlabs.repository;

import no.fintlabs.orgUnit.OrgUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrgUnitRepository extends JpaRepository<OrgUnit,Long> {

    Optional<OrgUnit> findByOrganisationUnitIdIgnoreCase(String organisationUnitId);

    Optional<OrgUnit> findOrgUnitByResourceIdEqualsIgnoreCase(String resourceid);


    @Query("select o from OrgUnit o where upper(o.name) like upper(concat('%', ?1, '%'))")
    List<OrgUnit> findOrgUnitsByOrgUnitName(String name);




}



