package be.technifutur.applicationMVC;

public interface VueInterface<T> {
	public void start();
	public StringBuilder getScreen();
	public void stop();
	public void setModel(T model);
}
