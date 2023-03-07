package no.fintlabs.orgUnit;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SimpleOrgUnit {
    private Long id;
    private String name;
    private String organisationUnitId;
}
