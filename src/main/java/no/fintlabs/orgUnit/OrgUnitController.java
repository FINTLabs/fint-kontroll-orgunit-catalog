package no.fintlabs.orgUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @GetMapping("{id}")
    public DetaildOrgUnit getOrgUnitById(@PathVariable Long id){
        log.info("Fetching orgunit by id: " + id);
        return orgUnitService.getDetaildOrgUnitById(id);
    }

    @GetMapping("/orgtree")
    public List<HierarchyOrgUnit> getOrgUnitStructure(){
        return hierarchyOrgUnitService.getOrgUnitStructure();
    }

    @GetMapping()
    public ResponseEntity<Map<String,Object>> getOrgUnits(@AuthenticationPrincipal Jwt jwt,
                                                          @RequestParam(value = "search", defaultValue = "%") String search,
                                                          @RequestParam(value="page", defaultValue = "0") int page,
                                                          @RequestParam(value="size", defaultValue = "${fint.kontroll.orgunit-catalog.pagesize:20}") int size){
        log.info("Fetching orgunits with searchparam: " + search);

        List<OrgUnit> orgUnitsByOrgUnitName = orgUnitService.findOrgUnitsByOrgUnitName(search);
        return ResponseFactory.toResponseEntity(orgUnitsByOrgUnitName,page,size);
    }
}
