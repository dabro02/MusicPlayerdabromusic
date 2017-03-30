package MusicPlayerPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.swing.*;

public class MainMusicPlayer extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}


	MainFrame frame1;
	JFrame frame;
	Lieder lieder;
	LiederSuchen liederSuchen;
	static boolean playOrPause = true;

	int actualwidth = 1366;
	int actualheight = 768;
	int actualX = 277;
	int actualY = 156;

	public static void main(String[] args)
	{

		new MainMusicPlayer().start();
	}
	public void start()
	{
		Music mp3file = Gdx.audio.newMusic(Gdx.files.external("core/src/MusicPlayerPackage/Liedertest/Alan Walker - Alone.mp3"));
		mp3file.play();
		this.liederSuchen = new LiederSuchen();
		this.lieder = new Lieder();
		lieder.liederImportieren();
		frame = new JFrame("dabromusic");
		frame1 = new MainFrame(this);
		frame.add(frame1);
		frame.setBounds(actualX,actualY,actualwidth,actualheight);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.updateMainFrame();
	}
}
