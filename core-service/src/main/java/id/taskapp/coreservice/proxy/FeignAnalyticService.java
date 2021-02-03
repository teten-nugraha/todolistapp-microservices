package id.taskapp.coreservice.proxy;

import id.taskapp.coreservice.dto.TaskDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

@Qualifier("analytic-service")
@FeignClient(
        value = "${application.config.feign.route.analytic-service}",
        fallback = FeignAnalyticServiceFallback.class,
        configuration = { DefaultFeignConfiguration.class}
)
public interface FeignAnalyticService {

    @PostMapping("/analytic/createFinishedTask")
    String createFinishedTask(@RequestBody final TaskDto dto);

}
