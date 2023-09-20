package no.fintlabs.orgunit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponseFactory {
    public static ResponseEntity<Map<String, Object>> toResponseEntity(Page<SimpleOrgUnit> userPage) {

        return new ResponseEntity<>(
                Map.of("totalItems", userPage.getTotalElements(),
                       "orgUnits", userPage.getContent(),
                       "currentPage", userPage.getNumber(),
                       "totalPages", userPage.getTotalPages()
                ),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<Map<String, Object>> toResponseEntity(List<OrgUnit> orgUnits, int page, int size) {
        return toResponseEntity(
                toPage(orgUnits.stream()
                               .map(OrgUnit::toSimpleOrgUnit)
                               .toList(),
                       PageRequest.of(page, size))
        );
    }

    private static Page<SimpleOrgUnit> toPage(List<SimpleOrgUnit> list, Pageable paging) {
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), list.size());

        return start > list.size()
                ? new PageImpl<>(new ArrayList<>(), paging, list.size())
                : new PageImpl<>(list.subList(start, end), paging, list.size());
    }
}
