package lk.slt.security.logfilemaster.services;

import lk.slt.security.logfilemaster.exception.StorageFileNotFoundException;
import lk.slt.security.logfilemaster.model.ErrorEntity;
import lk.slt.security.logfilemaster.services.StorageService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FileDownloadTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;

    @MockBean
    private FileService fileService;

    @Test
    public void shouldListAllFiles() throws Exception {
        given(this.fileService.getProcessedErrors())
                .willReturn(new ArrayList<ErrorEntity>());

        this.mvc.perform(get("/download")).andExpect(status().isOk())
        	.andExpect(header().string("Content-Type","application/octet-stream"))
                .andExpect(header().string("Content-Disposition", "attachment; filename= \"errors.xlsx\"" ));
    }

}
