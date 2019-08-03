package Chapter12;
import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class MiniMusicPlayer3
{
    static JFrame f = new JFrame ("My First Music Video"); //creates a new JFrame object called f and titles it
    static MyDrawPanelA ml; //creates a new MyDrawPanelA object called ml

    public static void main(String[] args)
    {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3(); //create a new object of MiniMusicPlayer3 called mini
        mini.go(); //call the go method on mini
    }

    public void setUpGui()//creates a new DrawPanelObject runs setCOntent Pane on f and passes ml
    {
        ml = new MyDrawPanelA();
        f.setContentPane(ml);
        f.setBounds(30, 30, 900, 900);
        f.setVisible(true);
    }

    public void go()
    {
        setUpGui();

        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 120; i += 4)
            {
                r = (int) (Math.random() * 50 + 1);
                track.add(makeEventA(144, 1, r, 109, i));
                track.add(makeEventA(176, 1, 127, 0, i)); //midi event for the eventcontroller on the same beat as note on
                track.add(makeEventA(128, 1, r, 109, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEventA(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try
        {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e)
        {

        }
        return event;
    }

    class MyDrawPanelA extends JPanel implements ControllerEventListener
    {
        boolean msg = false;

        public void controlChange(ShortMessage event)
        {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g)
        {
            if (msg)
            {
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r, gr, b));

                int ht = (int) ((Math.random() * 600) + 10);
                int width = (int) ((Math.random() * 600) + 10);
                int x = (int) ((Math.random() * 350) + 10);
                int y = (int) ((Math.random() * 350 ) + 10);

                g.fillRect(x, y, ht, width);
                msg = false;
            }

        }
    }
}
