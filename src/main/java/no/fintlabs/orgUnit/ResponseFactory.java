package no.fintlabs.orgUnit;

import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fintlabs.repository.OrgUnitRepository;
import no.vigoiks.resourceserver.security.FintJwtEndUserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Component
public class ResponseFactory {
    private final FintFilterService fintFilterService;
    private final OrgUnitRepository orgUnitRepository;


    public ResponseFactory(FintFilterService fintFilterService, OrgUnitRepository orgUnitRepository) {
        this.fintFilterService = fintFilterService;
        this.orgUnitRepository = orgUnitRepository;
    }

    public ResponseEntity<Map<String,Object>> toResponseEntity(
            FintJwtEndUserPrincipal principal, String filter,
            int page,
            int size ) {
        log.info("Creating response. Logged in user: " + principal.getGivenName() +" " + principal.getSurname());
        Stream<OrgUnit> orgUnitStream = orgUnitRepository.findAll().stream();
        ResponseEntity<Map<String,Object>> entity = toResponseEntity(
                toPage(
                        StringUtils.hasText(filter)
                        ? fintFilterService
                                .from(orgUnitStream,filter)
                                .map(OrgUnit::toSimpleOrgUnit).toList()
                                : orgUnitStream.map(OrgUnit::toSimpleOrgUnit).toList(),
                        PageRequest.of(page,size)

                )
        );
        return entity;
    }

    private Page<SimpleOrgUnit> toPage(List<SimpleOrgUnit> list, Pageable paging) {
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), list.size());

        return start > list.size()
                ? new PageImpl<>(new ArrayList<>(), paging, list.size())
                : new PageImpl<>(list.subList(start, end), paging, list.size());
    }

    public ResponseEntity<Map<String, Object>> toResponseEntity(Page<SimpleOrgUnit> userPage) {

        return new ResponseEntity<>(
                Map.of("totalItems", userPage.getTotalElements(),
                        "users", userPage.getContent(),
                        "currentPage", userPage.getNumber(),
                        "totalPages", userPage.getTotalPages()
                ),
                HttpStatus.OK
        );
    }
}
