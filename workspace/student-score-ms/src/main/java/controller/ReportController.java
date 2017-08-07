package controller;

import data.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.IReportService;

/**
 * Created by Shli on 07/08/2017.
 */
@RestController
public class ReportController {

    private IReportService reportService;

    @Autowired
    public void setReportService(IReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "/reports/{sids}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentsReport(@PathVariable("sids") String ids) throws Exception {
        return new ResponseEntity<Report>(reportService.genReport(ids), HttpStatus.OK);
    }
}
