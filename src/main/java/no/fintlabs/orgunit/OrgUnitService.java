package no.fintlabs.orgunit;

import no.fintlabs.opa.AuthorizationClient;
import no.fintlabs.repository.OrgUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class OrgUnitService {

    private final AuthorizationClient authorizationClient;
    private final OrgUnitRepository orgUnitRepository;

    public OrgUnitService(AuthorizationClient authorizationClient, OrgUnitRepository orgUnitRepository) {
        this.authorizationClient = authorizationClient;
        this.orgUnitRepository = orgUnitRepository;
    }

    public void save(OrgUnit orgUnit) {
        orgUnitRepository
                .findOrgUnitByResourceIdEqualsIgnoreCase(orgUnit.getResourceId())
                .ifPresentOrElse(onSaveExsistingOrgUnit(orgUnit), onSaveNewOrgUnit(orgUnit));
    }

    public List<OrgUnit> searchOrgUnits(String search) {
        Set<String> userOrgUnitIds = extractUserOrgUnitIds();
        return orgUnitRepository.findOrgUnitsByOrgUnitName(search, userOrgUnitIds);
    }

    public String getOrgUnitNameByOrgUnitId(String id) {
        Set<String> userOrgUnitIds = extractUserOrgUnitIds();

        return orgUnitRepository.findByOrganisationUnitIdIgnoreCase(id)
                .filter(orgUnit -> userOrgUnitIds.contains(orgUnit.getOrganisationUnitId()))
                .map(OrgUnit::getName)
                .orElse("");
    }

    private Runnable onSaveNewOrgUnit(OrgUnit orgUnit) {
        return () -> orgUnitRepository.save(orgUnit);
    }

    private Consumer<OrgUnit> onSaveExsistingOrgUnit(OrgUnit orgUnit) {
        return existingorgUnit -> {
            orgUnit.setId(existingorgUnit.getId());
            orgUnitRepository.save(orgUnit);
        };
    }

    private Set<String> extractUserOrgUnitIds() {
        return authorizationClient.getUserScopes().stream()
                .filter(scope -> scope.getObjectType().equalsIgnoreCase("orgunit"))
                .flatMap(scope -> scope.getOrgUnits().stream())
                .collect(Collectors.toSet());
    }

}
