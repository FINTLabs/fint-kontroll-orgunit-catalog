package no.fintlabs.orgunit;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleOrgUnit {
    private Long id;
    private String name;
    private String organisationUnitId;
    private String parentRef;
    private String parentName;
    private List<String> childrenRef;
}
