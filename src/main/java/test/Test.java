package test;

import com.jialvarador.data.entity.Actor;
import com.jialvarador.data.service.ActorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    ActorService service = (ActorService) context.getBean("actorService");
    Actor actor = new Actor();
    actor.setNombre("c");
    actor.setApellidoPaterno("a");
    service.addActor(actor);
  }

}
