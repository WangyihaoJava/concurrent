package com.example.concurrent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangyihao
 * @ClassName: AsyncConfig
 * @Description:
 * @date 2021/8/11 16:00
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Bean("ttlExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池核心容量
        executor.setCorePoolSize(20);
        // 设置线程池最大容量
        executor.setMaxPoolSize(100);
        // 设置任务队列长度
        executor.setQueueCapacity(200);
        // 设置线程超时时间
        executor.setKeepAliveSeconds(60);
        // 设置线程名称前缀
        executor.setThreadNamePrefix("ttl-executor-");
        // 设置任务丢弃后的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 设置任务的装饰
        executor.setTaskDecorator(new ContextCopyingDecorator());
        executor.initialize();
        return executor;
    }

    static class ContextCopyingDecorator implements TaskDecorator {
        @NonNull
        @Override
        public Runnable decorate(@NonNull Runnable runnable) {
            RequestAttributes context = RequestContextHolder.currentRequestAttributes();
            SecurityContext securityContext = SecurityContextHolder.getContext();
            return () -> {
                try {
                    RequestContextHolder.setRequestAttributes(context);
                    SecurityContextHolder.setContext(securityContext);
                    runnable.run();
                } finally {
                    SecurityContextHolder.clearContext();
                    RequestContextHolder.resetRequestAttributes();
                }
            };
        }
    }
}

