package no.fintlabs.orgunit;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.repository.OrgUnitRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class HierarchyOrgUnitService {
    private final OrgUnitRepository orgUnitRepository;
    private final OrgUnitService orgUnitService;

    public HierarchyOrgUnitService(OrgUnitRepository orgUnitRepository, OrgUnitService orgUnitService) {
        this.orgUnitRepository = orgUnitRepository;
        this.orgUnitService = orgUnitService;
    }

    public List<HierarchyOrgUnit> getOrgUnitStructure() {
        return orgUnitRepository.findAll()
                .stream()
                .map(orgUnit -> {
                    try {
                        return createHierarchyOrgUnit(orgUnit);
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    public HierarchyOrgUnit createHierarchyOrgUnit(OrgUnit orgUnit) throws ExecutionException, InterruptedException {

        HierarchyOrgUnit hierarchyOrgUnit = HierarchyOrgUnit
                .builder()
                .id(orgUnit.getId())
                .name(orgUnit.getName())
                .organisationUnitId(orgUnit.getOrganisationUnitId())
                .parentNameAndId(getParentNameAndID(orgUnit.getParentRef()))
                .childrenNameAndId(getChildrenNamesAndIds(orgUnit.getChildrenRef()))
                .build();
        return hierarchyOrgUnit;
    }


    private Map<String, String> getParentNameAndID(String parentRef) throws ExecutionException, InterruptedException {
        Map<String, String> parentNameAndId = new HashMap<>();
        String name = orgUnitRepository
                .findByOrganisationUnitIdIgnoreCase(parentRef)
                .map(OrgUnit::getName)
                .orElse("");
        parentNameAndId.put(parentRef, name);
        return parentNameAndId;
    }

    private Map<String,String> getChildrenNamesAndIds(List<String> childrenRef){
        Map<String,String> childNameAndId = new HashMap<>();
        List<String> childrenName = childrenRef
                .stream()
                .map(orgUnitService::getOrgUnitNameByOrgUnitId)
                .toList();
        for (int i = 0;i<childrenRef.size();i++){
            childNameAndId.put(childrenRef.get(i),childrenName.get(i));
        }
        return childNameAndId;
    }



}
