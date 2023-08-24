package ir.maktabsharif92.springboot.config;

import ir.maktabsharif92.springboot.base.config.security.AbstractCustomRequestDetail;
import ir.maktabsharif92.springboot.resource.LoginResource;
import org.springframework.stereotype.Component;

@Component
public class MyRequestDetail extends AbstractCustomRequestDetail {

    @Override
    public String[] getAllPermitAllUrls() {
        return new String[]{
                "/ns/**", LoginResource.PATH
        };
    }
}
