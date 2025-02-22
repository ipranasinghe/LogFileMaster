package lk.slt.security.logfilemaster.controller;

import lk.slt.security.logfilemaster.model.ErrorEntity;
import lk.slt.security.logfilemaster.services.FileService;
import lk.slt.security.logfilemaster.utilities.ErrorExcelExporter;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LogFileController {

    private static FileService logfileService;

    @Autowired
    public LogFileController(FileService logService) {
        this.logfileService = logService;
    }

    @RequestMapping(value="/ViewPage", method = RequestMethod.GET)
    public String viewsLogFile(Model model) {

        List<ErrorEntity> errors = logfileService.getProcessedErrors();
        model.addAttribute("errorList", errors);
        return "ViewPage";
    }

    @GetMapping("/download")
    public void exportExcelFile(HttpServletResponse response) throws IOException {

        //set file name and content type
        String filename = "errors.xlsx";

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename= \"" + filename + "\"";

        response.setHeader(headerKey, headerValue);

        List<ErrorEntity> errors = logfileService.getProcessedErrors();
        ErrorExcelExporter excelExporter = new ErrorExcelExporter(errors);
        Workbook myWorkbook = excelExporter.export();

        ServletOutputStream outputStream = response.getOutputStream();
        myWorkbook.write(outputStream);
        outputStream.close();


    }


}
