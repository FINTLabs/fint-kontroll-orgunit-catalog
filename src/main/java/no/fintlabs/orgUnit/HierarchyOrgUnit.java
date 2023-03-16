package no.fintlabs.orgUnit;

import lombok.*;

import java.util.HashMap;
import java.util.List;
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
    private Map<String,String> parentNameAndId= new HashMap<>();
    private Map<String,String> childrenNameAndId = new HashMap<>();


}
