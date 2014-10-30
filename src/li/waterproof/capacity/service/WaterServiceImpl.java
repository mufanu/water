package li.waterproof.capacity.service;

import li.waterproof.capacity.dao.WaterDao;
import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fail Mukhametdinov
 */
@org.springframework.stereotype.Service
public class WaterServiceImpl implements WaterService {

    private static final String FILES_ROOT_DIRECTORY = "/WEB-INF";
    private static final String SEPARATOR = java.io.File.separator;

    @Autowired
    ServletContext servletContext;

    @Autowired
    WaterDao waterDao;

    @Override
    public List<Result> get(Search search) {
        return waterDao.get(search);
    }

    @Override
    public List<Result> getCSV(Search search) throws JRException {
        String realPath = servletContext.getRealPath(FILES_ROOT_DIRECTORY);
        String filePath = realPath + SEPARATOR + "template.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(filePath);
        List<Result> results = get(search);
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(results);
        Map parameters = new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, parameters, jrBeanCollectionDataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
