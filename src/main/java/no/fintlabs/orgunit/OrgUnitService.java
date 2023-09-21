package no.fintlabs.orgunit;

import no.fintlabs.opa.AuthorizationClient;
import no.fintlabs.opa.model.Scope;
import no.fintlabs.repository.OrgUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<OrgUnit> findOrgUnitsByOrgUnitName(String search) {
        List<Scope> scopes = authorizationClient.getUserScopes();

        List<String> userOrgUnits = scopes.stream()
                .filter(scope -> scope.getObjectType().equalsIgnoreCase("orgunit"))
                .map(Scope::getOrgUnits)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return orgUnitRepository.findOrgUnitsByOrgUnitName(search, userOrgUnits);
    }
}
