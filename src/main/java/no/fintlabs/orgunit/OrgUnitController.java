package no.fintlabs.orgunit;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.orgunit.ResponseFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.math.NumberUtils.max;

@RestController
@Slf4j
@RequestMapping("/api/orgunits")
public class OrgUnitController {
    private final OrgUnitService orgUnitService;
    private final HierarchyOrgUnitService hierarchyOrgUnitService;

    public OrgUnitController(OrgUnitService orgUnitService, HierarchyOrgUnitService hierarchyOrgUnitService) {
        this.orgUnitService = orgUnitService;
        this.hierarchyOrgUnitService = hierarchyOrgUnitService;
    }

    @GetMapping("/orgtree")
    public List<HierarchyOrgUnit> getOrgUnitStructure(){
        return hierarchyOrgUnitService.getOrgUnitStructure();
    }

    @GetMapping()
    public ResponseEntity<Map<String,Object>> getOrgUnits(@AuthenticationPrincipal Jwt jwt,
                                                          @RequestParam(value = "search", defaultValue = "%") String search,
                                                          @RequestParam(value="page", defaultValue = "0") int page,
                                                          @RequestParam(value="size", defaultValue = "${fint.kontroll.orgunit-catalog.pagesize:20}") int size) {
        log.info("Fetching orgunits with searchparam: " + search);

        List<OrgUnit> orgUnitsByOrgUnitName = orgUnitService.searchOrgUnits(search);

        return ResponseFactory.toResponseEntity(orgUnitsByOrgUnitName,page,size);
    }
    @GetMapping("/{id}/parents" )
    public ResponseEntity<Map<String,Object>> getParentOrgUnits(@AuthenticationPrincipal Jwt jwt, @PathVariable("id") Long id){
        log.info("Fetching parent org units for orgunit: {}", id);

        List<OrgUnit> parentOrgUnits = orgUnitService.getParentOrgUnits(id);
        log.info("Found {} parent org units for orgunit {}: {}", parentOrgUnits.size(), id, parentOrgUnits.stream().map(OrgUnit::getId).toList());

        return ResponseFactory.toResponseEntity(parentOrgUnits, 0, max(parentOrgUnits.size(),1));
    }
    @GetMapping("/{id}/children" )
    public ResponseEntity<Map<String,Object>> getChildrenOrgUnits(@AuthenticationPrincipal Jwt jwt,
                                                                  @PathVariable("id") Long id
    ){
        log.info("Fetching children org units for orgunit: {}", id);

        List<OrgUnit> childrenOrgUnits = orgUnitService.getChildrenOrgUnits(id);
        log.info("Found {} children org units for orgunit {}", childrenOrgUnits.size(), id);
        log.debug("Children org units: {}", childrenOrgUnits.stream().map(OrgUnit::getId).toList());

        return ResponseFactory.toResponseEntity(childrenOrgUnits, 0, max(childrenOrgUnits.size(),1));
    }
}
