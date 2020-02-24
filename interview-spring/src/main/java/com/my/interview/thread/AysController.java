/**
 * 
 */
package com.my.interview.thread;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwei
 *
 */
@RequestMapping("/asy")
@RestController
@Slf4j
public class AysController {

	// rest 服务实现异步 callable
	@GetMapping("/callable")
	public Callable<String> call() {
		log.info("第一次当前线程名称:" + Thread.currentThread().getName());
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("调用了call 这个rest 等待这个线程执行完了 才给与返回 当前线程名称：" + Thread.currentThread().getName());
				Thread.sleep(5000);
				return "callable secuucs";
			}
		};
		log.info("第二次当前线程名称:" + Thread.currentThread().getName());
		return callable;
	}

}
