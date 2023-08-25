package ir.maktabsharif92.springboot.service.impl;

import ir.maktabsharif92.springboot.domain.AboutUs;
import ir.maktabsharif92.springboot.repository.AboutUsRepository;
import ir.maktabsharif92.springboot.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AboutUsServiceImpl implements AboutUsService {

    public static final String ABOUT_US_CACHE = "ABOUT_US_CACHE";

    private final AboutUsRepository baseRepository;

    @Override
    @Transactional
    public void init() {
        if (baseRepository.count() == 0) {
            baseRepository.save(
                    new AboutUs(
                            "محتوای درباره‌ی ما"
                    )
            );
        }
    }

    @Override
    @Cacheable(value = ABOUT_US_CACHE)
    public AboutUs get() {
        return baseRepository.findAll().get(0);
    }

    @Override
    @Transactional
    @CacheEvict(value = ABOUT_US_CACHE, allEntries = true)
    public AboutUs update(String content) {
        AboutUs aboutUs = get();
        aboutUs.setContent(content);
        return baseRepository.save(aboutUs);
    }
}
