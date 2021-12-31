package csumb.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import csumb.flashcard.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private Flashcard currentCard;
    private double flashcardCount;
    int currentFlashcard;
    private ActivityMainBinding binding;

    private List<Flashcard> flashcardBank = Arrays.asList(
            new Flashcard(R.string.question_compiler, R.string.answer_compiler),
            new Flashcard(R.string.question_os, R.string.answer_os),
            new Flashcard(R.string.question_rdbmbs, R.string.answer_rdbms),
            new Flashcard(R.string.question_https, R.string.answer_https)
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        flashcardCount = flashcardBank.size();
        currentFlashcard = 0;
        currentCard = flashcardBank.get(currentFlashcard);

        TextView question = (TextView) binding.questionView;
        question.setText(currentCard.questionId);

        Button showButton = binding.showAnswerButtonText;
        Button completeButton = binding.cardsFinishedText;
        Button randomButton = binding.randomButtonText;
        Button resetButton = binding.resetButtonText;

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showAnswer();
                }
            });

        completeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (flashcardCount != 0 && currentCard.complete != true) {
                    currentCard.complete = true;
                    flashcardCount--;
                    randomFlashcard();
                }
                else
                {
                    Toast.makeText(MainActivity.this, R.string.cards_finished_text,
                            Toast.LENGTH_LONG).show();
                    showButton.setEnabled(false);
                    completeButton.setEnabled(false);
                    randomButton.setEnabled(false);
                }
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(flashcardCount == 1)
                {
                    question.setText(currentCard.questionId);
                }else{
                    randomFlashcard();
                }
            }
        });

        resetButton.setOnClickListener(v -> resetCards());
    }

    class Flashcard {
        private int questionId;
        private int answerId;
        private boolean complete;

        public Flashcard(int questionId, int answerId) {
            this.questionId = questionId;
            this.answerId = answerId;
            this.complete = false;
        }

        public int getQuestionId() {
            return questionId;
        }

        public int getAnswerId() {
            return answerId;
        }

        public boolean isComplete() {
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }


    }

    public void randomFlashcard() {
            TextView question = binding.questionView;
            currentFlashcard = (currentFlashcard + 1) % flashcardBank.size(); //beautiful randomizer with no repeats
            currentCard = flashcardBank.get(currentFlashcard);
            question.setText(currentCard.questionId);

    }

    public void showAnswer(){
        Toast.makeText(MainActivity.this, currentCard.answerId,
                Toast.LENGTH_LONG).show();
    }

    public void resetCards(){
        TextView question = binding.questionView;
        currentFlashcard =0;
        flashcardCount = flashcardBank.size();
        Button showButton = binding.showAnswerButtonText;
        Button completeButton = binding.cardsFinishedText;
        Button randomButton = binding.randomButtonText;
        showButton.setEnabled(true);
        completeButton.setEnabled(true);
        randomButton.setEnabled(true);
        for(int i= 0;i<flashcardCount;i++)
        {
            flashcardBank.get(i).complete = false;
        }
        currentCard = flashcardBank.get(currentFlashcard);
        question.setText(currentCard.questionId);
    }


}