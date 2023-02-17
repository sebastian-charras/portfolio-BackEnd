package com.sebastian.portfolio;

import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.entities.WorkExperience;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sebastian Charras
 */
public class WorkExperienceTests {

    @Test
    public void WorkExperienceInstitutionRelationTest() {
        WorkExperience e1 = new WorkExperience();
        e1.setId(1);
        WorkExperience e2 = new WorkExperience();
        e2.setId(2);
        Institution i1 = new Institution();
        i1.setId(1);
        assertEquals(e1.getInstitution(), null);
        assertEquals(i1.getWorkExperiences().size(), 0);
        e1.addInstitution(i1);
        assertEquals(e1.getInstitution(), i1);
        assertEquals(i1.getWorkExperiences().size(), 1);
        e2.addInstitution(i1);
        assertEquals(e1.getInstitution(), i1);
        assertEquals(e2.getInstitution(), i1);
        assertEquals(i1.getWorkExperiences().size(), 2);
        e1.removeInstitution();
        assertEquals(e1.getInstitution(), null);
        assertEquals(e2.getInstitution(), i1);
        assertEquals(i1.getWorkExperiences().size(), 1);
        e2.removeInstitution();
        assertEquals(e1.getInstitution(), null);
        assertEquals(e2.getInstitution(), null);
        assertEquals(i1.getWorkExperiences().size(), 0);
    }
}
