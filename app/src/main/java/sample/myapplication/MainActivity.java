package sample.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    //variables
    Button b_rock, b_paper, b_scissors;
    ImageView iv_cpu, iv_me;
    TextView textView;

    String myChoice, cpuChoice, result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references to the buttons, text view & image view
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        textView = (TextView) findViewById(R.id.textView);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        //random number generator
        r = new Random();

        //rock button action
        b_rock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        //paper button action
        b_paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        //scissor button action
        b_scissors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myChoice = "scissor";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();
            }
        });
    }

    private void calculate()
    {
        //cpu random decision making
        int cpu = r.nextInt(3);

        if (cpu == 0)
        {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 1)
        {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 2)
        {
            cpuChoice = "scissor";
            iv_cpu.setImageResource(R.drawable.scissor);
        }

        //all the different kinds of outcome when chosen different option
        //Total of 9 different option
        if (myChoice.equals("rock") && cpuChoice.equals("paper"))
        {
            result = "You Loose!";
        } else if (myChoice.equals("scissor") && cpuChoice.equals("paper"))
        {
            result = "You Win!";
        } else if (myChoice.equals("scissor") && cpuChoice.equals("rock"))
        {
            result = "You Loose!";
        } else if (myChoice.equals("scissor") && cpuChoice.equals("scissor"))
        {
            result = "Draw!";
        } else if (myChoice.equals("rock") && cpuChoice.equals("scissor"))
        {
            result = "You Win!";
        } else if (myChoice.equals("paper") && cpuChoice.equals("rock"))
        {
            result = "You Win!";
        } else if (myChoice.equals("paper") && cpuChoice.equals("scissor"))
        {
            result = "You Loose!";
        } else if (myChoice.equals("paper") && cpuChoice.equals("paper"))
        {
            result = "Draw!";
        } else if (myChoice.equals("rock") && cpuChoice.equals("rock"))
        {
            result = "Draw!";
        }

        //print out to the text view
        //changes color and size depending on what the result is
        textView.setText(result);
        textView.setTextColor(Color.RED);
        if (result.equals("You Win!"))
        {
            textView.setTextSize(23);
        } else
        {
            textView.setTextSize(18);
        }
    }
}
