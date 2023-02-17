package no.fintlabs.orgUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
