import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TrackerGUI extends JFrame{
    private JPanel TrackerGUI;
    private JProgressBar dailyProgress;
    private JButton dailyResetButton;
    private JProgressBar weeklyProgress;
    private JButton weeklyResetButton;
    private JButton finishTask;
    private JButton undoButton;
    private JLabel dailyGoalLabel;
    private JLabel weeklyGoalLabel;
    private JLabel dailyAmount;
    private JLabel weeklyAmount;
    private JPanel Tguii;
    private int counter = 0;
    private int weeklyCounter = 0;

    public void updateProgBars(){
        dailyProgress.setValue(counter);
        weeklyProgress.setValue(weeklyCounter);
    }

    public void setBoth(int counter, int weeklyCounter){
        dailyAmount.setText(String.valueOf(counter));
        weeklyAmount.setText(String.valueOf(weeklyCounter));
    }

    public void setDaily(int counter){
        dailyAmount.setText(String.valueOf(counter));
    }

    public void setWeekly(int weeklyCounter){
        weeklyAmount.setText(String.valueOf(weeklyCounter));
    }

    public void setDailyBar(){
        dailyProgress.setValue(counter);
    }

    public void setWeeklyBar(){
        weeklyProgress.setValue(counter);
    }

    public TrackerGUI(){
        setContentPane(Tguii);
        setTitle("LP_Task_Track");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        finishTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (e.getSource() == finishTask){
             counter++;
             weeklyCounter++;
             setBoth(counter, weeklyCounter);
             updateProgBars();
            }
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == undoButton) {
                    counter--;
                    weeklyCounter--;
                    setBoth(counter, weeklyCounter);
                    updateProgBars();}
            }
        });

        dailyResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == dailyResetButton){
                    counter = 0;
                    setDaily(counter);
                    setDailyBar();}
            }
        });

        weeklyResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == weeklyResetButton){
                    weeklyCounter = 0;
                    setWeekly(weeklyCounter);
                    setWeeklyBar();}
            }
        });
    }

    public static void main(String[] args) {
        TrackerGUI LPTracker = new TrackerGUI();
    }

}
