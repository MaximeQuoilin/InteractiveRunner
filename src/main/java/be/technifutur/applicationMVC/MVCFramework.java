package be.technifutur.applicationMVC;
import be.technifutur.applicationRunner.ConsoleEnvironnment;
import be.technifutur.applicationRunner.Environment;
import be.technifutur.applicationRunner.InteractiveRunner;

public class MVCFramework<T> {
	
	public void start(MVCFactoryInterface<T> factory) {
		InteractiveRunner runner = new InteractiveRunner();
		ApplicationMVC<T> app = new ApplicationMVC<T>();
		Environment env = new ConsoleEnvironnment();
		T model = factory.getModel();
		VueInterface<T> vue = factory.getVue();
		ControlerInterface<T> controler = factory.getControler();
		
		vue.setModel(model);
		controler.setModel(model);
		app.setControler(controler);
		app.setModel(model);
		app.setVue(vue);
		
		runner.setApplication(app);
		runner.setEnv(env);		
		
		runner.run();
	}
}
