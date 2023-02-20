package no.fintlabs.orgUnit;

import lombok.extern.slf4j.Slf4j;
import no.vigoiks.resourceserver.security.FintJwtEndUserPrincipal;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/api/orgunits")
public class OrgUnitController {
    private final OrgUnitService orgUnitService;
    private final ResponseFactory responseFactory;

    public OrgUnitController(OrgUnitService orgUnitService, ResponseFactory responseFactory) {
        this.orgUnitService = orgUnitService;
        this.responseFactory = responseFactory;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOrgUnits(@AuthenticationPrincipal Jwt jwt,
                                                           @RequestParam(value="$filter",required = false) String filter,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "${fint.kontroll.orgunit-catalog.pagesize:20}") int size) {
        log.info("Finding orgunits with filter: " +filter+ " at page: " +page+ " (first page =0)");
        return responseFactory.toResponseEntity(
                FintJwtEndUserPrincipal.from(jwt),filter,page,size);
    }

    @GetMapping("{id}")
    public Mono<DetaildOrgUnit> getOrgUnitById(@PathVariable Long id){
        log.info("Fetching orgunit by id: " + id);
        return orgUnitService.getDetaildOrgUnitById(id);
    }


}
