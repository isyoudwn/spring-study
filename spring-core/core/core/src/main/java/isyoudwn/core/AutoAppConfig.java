package isyoudwn.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 클래스를 스캔해서 빈으로 등록한다.
@ComponentScan(
        // Configuration 붙은 것을 Bean으로 등록 하지 않게 하기 위함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
