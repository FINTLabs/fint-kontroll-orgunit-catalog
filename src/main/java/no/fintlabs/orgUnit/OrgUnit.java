package no.fintlabs.orgUnit;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "orgunits")
public class OrgUnit {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceId;
    private String organisationUnitId;
    private String name;
    private String shortName;
    private String parentRef;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> childrenRef = new ArrayList<>();
    private String managerRef;


    public SimpleOrgUnit toSimpleOrgUnit() {

        return SimpleOrgUnit
                .builder()
                .id(id)
                .name(name)
                .organisationUnitId(organisationUnitId)
                .parentRef(parentRef)
                .childrenRef(childrenRef)
                .build();
    }

    public DetaildOrgUnit toDetaildOrgUnit() {
        return DetaildOrgUnit
                .builder()
                .id(id)
                .name(name)
                .shortName(shortName)
                .parentRef(parentRef)
                .childrenRef(childrenRef)
                .build();

    }
}
