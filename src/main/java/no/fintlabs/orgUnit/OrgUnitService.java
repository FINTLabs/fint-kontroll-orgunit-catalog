package no.fintlabs.orgUnit;

import no.fintlabs.repository.OrgUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgUnitService {
    private final OrgUnitRepository orgUnitRepository;

    public OrgUnitService(OrgUnitRepository orgUnitRepository) {
        this.orgUnitRepository = orgUnitRepository;
    }

    public OrgUnit save(OrgUnit orgUnit) {
        String orgUnitResourceId =   orgUnit.getResourceId();
        OrgUnit existingOrgUnit = orgUnitRepository.findOrgUnitByResourceIdEqualsIgnoreCase(orgUnitResourceId).orElse(null);
        if (existingOrgUnit == null) {
            OrgUnit newOrgUnit = orgUnitRepository.save(orgUnit);
            return newOrgUnit;
        } else {
            orgUnit.setId(existingOrgUnit.getId());
            return orgUnitRepository.save(orgUnit);

        }
    }
}
