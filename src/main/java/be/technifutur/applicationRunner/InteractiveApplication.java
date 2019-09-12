package be.technifutur.applicationRunner;

public interface InteractiveApplication {
	public void start();
	public StringBuilder getScreen();
	public boolean isFinish();
	public void newInput(String input);
	public void stop();
	public boolean hasLastScreen();
}
