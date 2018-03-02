package kr.co.kms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//AOP 클래스 생성시 component-scan에 의한 빈 설정을 위해(객체되기위해) 어노테이션 붙여줘야함
@Component
//exAOP클래스에 advice가 들어있다 라는 것을 알려줌
@Aspect
public class ExAOP {
	
	//Advice : 실제 실행 할 수 있는 부가적인 작업들(메소드)
	//@Around 포인트컷을 활용할때는 항상 매개변수에 ProceedingJoinPoint가 있어야 한다.
	@Around("execution(* kr.co.kms.service..test*(..))") /*여기서 .. 이면 service 패키지 하위에 있는 모든 클래스를 의미함 & test* 은 test로 시작하는 모든 메소드를 의미함*/
	Object testAOP1(ProceedingJoinPoint joinPoint) throws Throwable{ //포인트컷이 잘 걸렷나 어라운드포인트컷 모양(주황색화살표!)으로 확인할 수 있다.
		System.out.println("testAOP1 - Advice 실행함. joinPoint 실행 직전");
		Object obj = null; //proceed에 의한 리턴을 받아낼 용도
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("testAOP1 - Advice 실행함. joinPoint 실행 이후");
		}
		return obj;
	}
	
	@Around("execution(* kr.co.kms.service..*doBService(..))")	
	Object testAOP2(ProceedingJoinPoint joinPoint) throws Throwable{ //포인트컷이 잘 걸렷나 어라운드포인트컷 모양(주황색화살표!)으로 확인할 수 있다.
		System.out.println("testAOP2 - Advice 실행함. joinPoint 실행 직전");
		Object obj = null; //proceed에 의한 리턴을 받아낼 용도
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("testAOP2 - Advice 실행함. joinPoint 실행 이후");
		}
		return obj;
	}
	
	@Around("within(kr.co.kms.service2..*)")
	void withInAOP(ProceedingJoinPoint joinPoint) throws Throwable{
		
	}
	

}
