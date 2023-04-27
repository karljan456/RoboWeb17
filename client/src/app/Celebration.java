package app;

public class Celebration extends Thread {

	static Disco disco = new Disco();

	static Music music = new Music();


	@Override
	public void run() {
		music.start();
		disco.start();
	}

}


