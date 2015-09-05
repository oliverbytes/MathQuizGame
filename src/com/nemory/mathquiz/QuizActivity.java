package com.nemory.mathquiz;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private ArrayList<Question> _questions = new ArrayList<Question>();
	private Question _currentQuestion = new Question();
	private long score = 0;
	private long totalScore = 0;

	private Button btnA, btnB, btnC;
	private TextView tvQuestion, tvScore;

	private MediaPlayer mpCorrect, mpWrong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		this.initialize();
		this.readyQuestions();
		this.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}

	private void start() {
		this.next();
	}

	private void restart() {
		this.score = 0;
		tvScore.setText("Score: " + this.score + " / " + this.totalScore);
		this._currentQuestion = null;
		this._questions.clear();
		this.readyQuestions();
		this.start();
	}

	private void stop() {
		AlertDialog d = new AlertDialog.Builder(this).create();
		d.setCancelable(false);
		d.setTitle("Game Finished");
		d.setMessage("Score: " + this.score + " / " + this.totalScore);

		d.setButton(d.BUTTON_POSITIVE, "Restart",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						restart();
					}
				});

		d.setButton(d.BUTTON_NEGATIVE, "Back to menu",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});

		d.show();
	}

	private void next() {
		this.randomize();

		if (_questions.size() > 0) {
			this._currentQuestion = _questions.get(0);
			_questions.remove(0);
		} else {
			this.stop();
			return;
		}

		this.display();
	}

	private void display() {
		tvQuestion.setText(_currentQuestion.getText());
		btnA.setText(_currentQuestion.getChoiceA());
		btnB.setText(_currentQuestion.getChoiceB());
		btnC.setText(_currentQuestion.getChoiceC());
	}

	private void randomize() {
		Collections.shuffle(_questions);
	}

	private void compare(String userAnswer, String correctAnswer) {
		if (userAnswer.trim().equals(correctAnswer)) {
			this.score++;
			tvScore.setText("Score: " + this.score + " / " + this.totalScore);
			mpCorrect.start();
		} else {
			this.toast("Wrong! Correct answer: " + correctAnswer);
			mpWrong.start();
		}

		this.next();
	}

	private void toast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	public void btnAClick(View v) {
		String userAnswer = ((Button) v).getText().toString();
		this.compare(userAnswer, _currentQuestion.getAnswer());
	}

	public void btnBClick(View v) {
		String userAnswer = ((Button) v).getText().toString();
		this.compare(userAnswer, _currentQuestion.getAnswer());
	}

	public void btnCClick(View v) {
		String userAnswer = ((Button) v).getText().toString();
		this.compare(userAnswer, _currentQuestion.getAnswer());
	}

	public void btnRestartClick(View v) {
		
		AlertDialog d = new AlertDialog.Builder(this).create();
		d.setCancelable(false);
		d.setTitle("Warning!");
		d.setMessage("Restarting the game will reset your score.");

		d.setButton(d.BUTTON_POSITIVE, "Restart",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						restart();
					}
				});

		d.setButton(d.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});

		d.show();
	}

	public void btnExitClick(View v) {
		this.finish();
	}

	private void readyQuestions() {
		Question q = null;

		q = new Question();
		q.setText("1 + 1");
		q.setAnswer("1");
		q.setChoiceA("1");
		q.setChoiceB("2");
		q.setChoiceC("3");
		_questions.add(q);
		
		q = new Question();
		q.setText("10 + 20");
		q.setAnswer("30");
		q.setChoiceA("10");
		q.setChoiceB("20");
		q.setChoiceC("30");
		_questions.add(q);
		
		q = new Question();
		q.setText("100 + 7");
		q.setAnswer("107");
		q.setChoiceA("101");
		q.setChoiceB("106");
		q.setChoiceC("107");
		_questions.add(q);
		
		q = new Question();
		q.setText("6 + 2");
		q.setAnswer("8");
		q.setChoiceA("7");
		q.setChoiceB("8");
		q.setChoiceC("9");
		_questions.add(q);
		
		q = new Question();
		q.setText("20 x 2");
		q.setAnswer("40");
		q.setChoiceA("40");
		q.setChoiceB("30");
		q.setChoiceC("50");
		_questions.add(q);
		
		q = new Question();
		q.setText("60 x 1");
		q.setAnswer("60");
		q.setChoiceA("60");
		q.setChoiceB("61");
		q.setChoiceC("1");
		_questions.add(q);
		
		q = new Question();
		q.setText("1 / 1");
		q.setAnswer("1");
		q.setChoiceA("1");
		q.setChoiceB("0");
		q.setChoiceC("2");
		_questions.add(q);
		
		q = new Question();
		q.setText("6 x 6");
		q.setAnswer("36");
		q.setChoiceA("36");
		q.setChoiceB("100");
		q.setChoiceC("66");
		_questions.add(q);
		
		q = new Question();
		q.setText("9 x 9");
		q.setAnswer("81");
		q.setChoiceA("99");
		q.setChoiceB("81");
		q.setChoiceC("89");
		_questions.add(q);
		
		q = new Question();
		q.setText("60 / 3");
		q.setAnswer("63");
		q.setChoiceA("20");
		q.setChoiceB("30");
		q.setChoiceC("10");
		_questions.add(q);
		
		q = new Question();
		q.setText("100 + 101");
		q.setAnswer("201");
		q.setChoiceA("101");
		q.setChoiceB("201");
		q.setChoiceC("200");
		_questions.add(q);
		
		q = new Question();
		q.setText("1 + 9");
		q.setAnswer("10");
		q.setChoiceA("10");
		q.setChoiceB("11");
		q.setChoiceC("9");
		_questions.add(q);
		
		q = new Question();
		q.setText("88 + 2");
		q.setAnswer("90");
		q.setChoiceA("90");
		q.setChoiceB("91");
		q.setChoiceC("89");
		_questions.add(q);
		
		q = new Question();
		q.setText("50 x 3");
		q.setAnswer("150");
		q.setChoiceA("100");
		q.setChoiceB("150");
		q.setChoiceC("250");
		_questions.add(q);
		
		q = new Question();
		q.setText("40 / 2");
		q.setAnswer("20");
		q.setChoiceA("42");
		q.setChoiceB("21");
		q.setChoiceC("20");
		_questions.add(q);
		
		q = new Question();
		q.setText("0 - 1");
		q.setAnswer("-1");
		q.setChoiceA("-1");
		q.setChoiceB("1");
		q.setChoiceC("0");
		_questions.add(q);
		
		q = new Question();
		q.setText("1 + 10");
		q.setAnswer("11");
		q.setChoiceA("11");
		q.setChoiceB("12");
		q.setChoiceC("13");
		_questions.add(q);
		
		q = new Question();
		q.setText("0 x 390");
		q.setAnswer("0");
		q.setChoiceA("0");
		q.setChoiceB("390");
		q.setChoiceC("3900");
		_questions.add(q);
		
		this.totalScore = _questions.size();
		this.score = 0;
		
		tvScore.setText("Score: " + this.score + " / " + this.totalScore);
	}

	private void initialize() {
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		tvScore = (TextView) findViewById(R.id.tvScore);
		
		btnA = (Button) findViewById(R.id.btnA);
		btnB = (Button) findViewById(R.id.btnB);
		btnC = (Button) findViewById(R.id.btnC);
		
		mpCorrect = MediaPlayer.create(this, R.raw.correct);
		mpWrong = MediaPlayer.create(this, R.raw.wrong);
	}
}
