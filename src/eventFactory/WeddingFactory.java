package eventFactory;

import event.CompositeEvent;
import event.EventComponent;

public class WeddingFactory implements EventFactory {
    

	
	public EventComponent createEvent() {
        CompositeEvent weddingEvent = new CompositeEvent("Свадьба");

//        // Создаем подмероприятия и добавляем их к свадьбе
//        EventComponent ceremony = new Event("Церемония");
//        EventComponent banquet = new Event("Банкет");
//        EventComponent photoSession = new Event("Фотосессия");
//    
//        
//        // Создаем работника для мероприятия "фотосессия" с профессией из фабрики
////        Worker worker = new Worker("", TypeWorker.PHOTOGRAPHER);
////        photoSession = new WorkerDecorator(photoSession, worker);
//        
//        weddingEvent.add(ceremony);
//        weddingEvent.add(banquet);
//        weddingEvent.add(photoSession);
//
//        
//
//        
//      
       return weddingEvent;
//    }
//
//	public WeddingFactory() {
//		super();
//	}

	
	

	}
}
