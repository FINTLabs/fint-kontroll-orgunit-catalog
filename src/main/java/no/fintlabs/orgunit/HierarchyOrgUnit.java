package no.fintlabs.orgunit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HierarchyOrgUnit {
    private Long id;
    private String name;
    private String organisationUnitId;
    private Map<String,String> parentNameAndId;
    private Map<String,String> childrenNameAndId;


}
