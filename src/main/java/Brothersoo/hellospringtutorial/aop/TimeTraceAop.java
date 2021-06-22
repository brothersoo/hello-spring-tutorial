package Brothersoo.hellospringtutorial.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TimeTraceAop {

  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

    long start = System.currentTimeMillis();
    logger.info("START: {}", start);

    try {
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;

      logger.info("FINISH: {}", timeMs);
    }
  }
}
