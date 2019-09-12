package be.technifutur.applicationMVC;

import be.technifutur.applicationRunner.InteractiveApplication;

public class ApplicationMVC<T> implements InteractiveApplication {
	private VueInterface<T> vue;
	private ControlerInterface<T> controler;
	private T model;

	@Override
	public void start() {
		controler.setModel(this.model);
		vue.setModel(this.model);
		controler.start();
		vue.start();
	}

	@Override
	public StringBuilder getScreen() {
		return vue.getScreen();
	}

	@Override
	public boolean isFinish() {		
		return controler.isFinish();
	}

	@Override
	public void newInput(String input) {
		controler.newInput(input);
	}

	@Override
	public void stop() {
		vue.stop();
		controler.stop();
	}

	@Override
	public boolean hasLastScreen() {
		return controler.hasLastScreen();
	}

	/**
	 * @param vue the vue to set
	 */
	public void setVue(VueInterface<T> vue) {
		this.vue = vue;
	}

	/**
	 * @param controler the controler to set
	 */
	public void setControler(ControlerInterface<T> controler) {
		this.controler = controler;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(T model) {
		this.model = model;
	}

}
