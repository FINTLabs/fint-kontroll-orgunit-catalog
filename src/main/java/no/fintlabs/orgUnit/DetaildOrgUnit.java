package no.fintlabs.orgUnit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class DetaildOrgUnit {
    private Long id;
    private String name;
    private String shortName;
    private String parentRef;
    private List<String> childrenRef = new ArrayList<>();
}
