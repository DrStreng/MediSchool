package web;

import domain.SchoolClass;
import repositories.ICatalogRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by Dawid_2 on 2015-01-21.
 */
@SessionScoped
@Transactional
@Named("SchoolClassBean")
public class SCFormBean implements Serializable {

    private static long serialVersionUID = 1L;
    private ListDataModel<SchoolClass> scs = new ListDataModel<SchoolClass>();
    private SchoolClass sc = new SchoolClass();

    @Inject
    private ICatalogRepository catalog;

    public SchoolClass getSchoolClass() {
        return sc;
    }

    public void setSchoolClass(SchoolClass sc) {
        this.sc = sc;
    }

    public String saveSC() {
        catalog.getSchoolClassRepo().add(sc);
        sc = new SchoolClass();
        return "schoolClass";
    }

    public ListDataModel<SchoolClass> getSCs() {
        scs.setWrappedData(catalog.getSchoolClassRepo().get(sc.getId()));
        return scs;
    }

    public String deleteSC() {
        SchoolClass schoolClass = scs.getRowData();
        SchoolClass schoolClassToDelete = catalog.getSchoolClassRepo().get(schoolClass.getId());
        catalog.getSchoolClassRepo().delete(schoolClassToDelete);
        return "schoolClass";
    }

    public String editSC() {
        sc = scs.getRowData();
        return "editSchoolClass";
    }

    public String editAll() {
        SchoolClass s = catalog.getSchoolClassRepo().get(sc.getId());
        s.setNumber(s.getNumber());
        s.setGrupa(s.getGrupa());
        return "schoolClass";
    }

}
