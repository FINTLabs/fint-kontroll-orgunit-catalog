package no.fintlabs.orgUnit;

import no.fintlabs.repository.OrgUnitRepository;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class OrgUnitService {
    private final OrgUnitRepository orgUnitRepository;

    public OrgUnitService(OrgUnitRepository orgUnitRepository) {
        this.orgUnitRepository = orgUnitRepository;
    }

    public void save(OrgUnit orgUnit){
        orgUnitRepository
                .findOrgUnitByResourceIdEqualsIgnoreCase(orgUnit.getResourceId())
                .ifPresentOrElse(onSaveExsistingOrgUnit(orgUnit), onSaveNewOrgUnit(orgUnit));
    }

    private Runnable onSaveNewOrgUnit(OrgUnit orgUnit) {
        return ()-> {
            OrgUnit newOrgUnit = orgUnitRepository.save(orgUnit);
        };
    }

    private Consumer<OrgUnit> onSaveExsistingOrgUnit(OrgUnit orgUnit) {
        return existingorgUnit -> {
            orgUnit.setId(existingorgUnit.getId());
            orgUnitRepository.save(orgUnit);
        };
    }

    public DetaildOrgUnit getDetaildOrgUnitById(Long id) {
        return orgUnitRepository.findById(id)
                .map(OrgUnit::toDetaildOrgUnit)
                .orElse(new DetaildOrgUnit());
    }


    public String getOrgUnitNameByOrgUnitId(String id){
        return orgUnitRepository.findByOrganisationUnitIdIgnoreCase(id)
                .map(OrgUnit::getName)
                .orElse("");
    }


}
