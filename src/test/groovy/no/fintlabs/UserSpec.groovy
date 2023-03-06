package no.fintlabs

import no.fintlabs.orgUnit.OrgUnit
import spock.lang.Specification

class UserSpec extends Specification {
    def "converting from orgunit to simple orgunit"() {
        given:
        def orgUnit = OrgUnit
                .builder()
                .id(4711L)
                .name("OrgUnit navn")
                .build()

        when:
        def simpleOrgUnit = orgUnit.toSimpleOrgUnit()

        then:
        simpleOrgUnit.getId() == orgUnit.getId()
        simpleOrgUnit.getName() == orgUnit.getName()


    }

    def "converting from orgunit to detailedOrgunit"() {
        given:
        def orgunit = OrgUnit
                .builder()
                .id(4711L)
                .name("OrgUnit navn")
                .shortName("OU navn")
                .parentRef("https://ref.til.parent")
                .childrenRef(List.of("ou1", "OU2", "OU3"))
                .build()

        when:
        def detailedOrgUnit = orgunit.toDetaildOrgUnit()

        then:
        detailedOrgUnit.getId() == orgunit.getId()
        detailedOrgUnit.getName() == orgunit.getName()
        detailedOrgUnit.getShortName() == orgunit.getShortName()
        detailedOrgUnit.getParentRef() == orgunit.getParentRef()
        detailedOrgUnit.getChildrenRef() == orgunit.getChildrenRef()
    }
}
