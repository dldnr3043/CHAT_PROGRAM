package com.ldu.chat.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import io.lettuce.core.ReadFrom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Redis Config to java file
 * ㄴ profiles 별 redis cluster or redis standard 적용 위해 java 파일로도 redis config 생성
 * 
 * ㄴ redis client     : lettuce
 * ㄴ redis standalone : local, dev
 * ㄴ redis cluster    : production
 *   ㄴ yml file 내 redis cluster refresh period/adaptive 확인 (적응형 redis cluster topology refresh 적용여부)
 * 
 * @author ldu
 *
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class RedisConfig {
	
	@Value("${spring.profiles.active}")
    private String profile;
	private final RedisProperties redisProperties;
	
	@Bean
    public RedisConnectionFactory redisConnectionFactory()
    {
    	log.info("Redis - connection profile={}", profile);
    	
        switch(profile)
        {
            case "local": case "dev": /* redis cluster사용시 dealut구문 */
            {
            	log.info("Redis - Standalone Configuration !! \n\n\t [host={}:{}]\n", redisProperties.getHost(), redisProperties.getPort());
                RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
                redisStandaloneConfiguration.setHostName(redisProperties.getHost());
                redisStandaloneConfiguration.setPort(redisProperties.getPort());
                redisStandaloneConfiguration.setPassword(redisProperties.getPassword());
                LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
                return lettuceConnectionFactory;
            }
            case "production":
            {
            	log.info("Redis - Cluster Configuration !! \n\n\t [cluster-nodes={}]\n", redisProperties.getCluster().getNodes());
            	RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
            	
            	LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
            			                                                                          .readFrom(ReadFrom.REPLICA_PREFERRED)
            			                                                                          .build();
            	
            	LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration, lettuceClientConfiguration);
            	
            	return lettuceConnectionFactory;
            }
            default:
            {
            	log.info("Redis - Standalone Configuration !! \n\n\t [host={}:{}]\n", redisProperties.getHost(), redisProperties.getPort());
                RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
                redisStandaloneConfiguration.setHostName(redisProperties.getHost());
                redisStandaloneConfiguration.setPort(redisProperties.getPort());
                redisStandaloneConfiguration.setPassword(redisProperties.getPassword());
                LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
                return lettuceConnectionFactory;
            }
        }
    }
}
