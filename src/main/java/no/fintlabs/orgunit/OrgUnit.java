package no.fintlabs.orgunit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "org_unit")
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
    private List<String> childrenRef;
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
