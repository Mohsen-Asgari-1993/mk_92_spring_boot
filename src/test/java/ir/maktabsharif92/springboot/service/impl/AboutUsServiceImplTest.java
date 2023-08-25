package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.domain.AboutUs;
import ir.maktabsharif92.springboot.repository.AboutUsRepository;
import ir.maktabsharif92.springboot.service.AboutUsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles(value = "test")
class AboutUsServiceImplTest {

    private final AboutUsRepository aboutUsRepository = Mockito.mock(AboutUsRepository.class);

    private final AboutUsService aboutUsServiceWithMockRepo = new AboutUsServiceImpl(aboutUsRepository);

    @Autowired
    private AboutUsService realAboutUsService;

    @BeforeEach
    public void each() {
        when(aboutUsRepository.findAll()).thenReturn(
                List.of(
                        new AboutUs("test")
                )
        );

        when(
                aboutUsRepository.save(any())
        ).thenReturn(
                new AboutUs(
                        "any"
                )
        );
    }

    @Test
    void get() {
        Assertions.assertEquals(
                "test",
                aboutUsServiceWithMockRepo.get().getContent()
        );
    }

    @Test
    void update() {
        Assertions.assertEquals(
                "any",
                aboutUsServiceWithMockRepo.update("123").getContent()
        );
    }

    @Test
    void updateWithRealService() {
        String content = "new content";
        AboutUs updatedAboutUs = realAboutUsService.update(content);
        Assertions.assertEquals(
                content,
                updatedAboutUs.getContent()
        );
    }
}