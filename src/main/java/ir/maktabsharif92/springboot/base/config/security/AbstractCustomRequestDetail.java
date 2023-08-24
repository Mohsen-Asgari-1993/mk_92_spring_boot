package ir.maktabsharif92.springboot.base.config.security;

public abstract class AbstractCustomRequestDetail implements CustomRequestDetail {

    @Override
    public String[] getAllPermitAllUrls() {
        return new String[]{
                "/ns/**"
        };
    }
}
