package no.fintlabs.orgUnit;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class SimpleOrgUnit {
    private Long id;
    private String name;
    private String organisationUnitId;
    private String parentRef;
    private String parentName;
    private List<String> childrenRef;
}
