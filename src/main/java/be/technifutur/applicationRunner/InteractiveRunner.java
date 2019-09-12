package be.technifutur.applicationRunner;

public class InteractiveRunner implements Runnable {

	private InteractiveApplication application;
	private Environment env;

	public void run() {
		if (application != null) {
			application.start();
			while (!application.isFinish()) {
				env.print(application.getScreen().toString());
				application.newInput(env.nextLine());
			}
			if (this.application.hasLastScreen()) {
				env.print(application.getScreen());
			}
			application.stop();
		}
	}

	public InteractiveApplication getApplication() {
		return application;
	}

	public void setApplication(InteractiveApplication application) {
		this.application = application;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		if (env == null) {
			throw new NullEnvironementPointerException();
		}
		this.env = env;
	}

}
