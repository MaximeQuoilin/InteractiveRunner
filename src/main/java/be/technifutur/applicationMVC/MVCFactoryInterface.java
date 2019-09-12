package be.technifutur.applicationMVC;

public interface MVCFactoryInterface<T> {
	T getModel();
	ControlerInterface<T> getControler();
	VueInterface<T> getVue();
}
